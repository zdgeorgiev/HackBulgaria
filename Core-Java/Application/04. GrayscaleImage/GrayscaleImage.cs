using System;
using System.Drawing;

class GrayscaleImage
{
    static void Main(string[] args)
    {
        string path = "../../original.jpg";
        Image img = Image.FromFile(path);

        ConvertToGrayscale(new Bitmap(img));
    }

    static void ConvertToGrayscale(Bitmap img)
    {
        Bitmap grayImgBitMap = new Bitmap(img.Width, img.Height);

        for (int i = 0; i < img.Width; i++)
        {
            for (int j = 0; j < img.Height; j++)
            {
                Color pixel = img.GetPixel(i, j);

                int grayscale = (int)(pixel.R * 0.299 + pixel.B * 0.114 + pixel.G * 0.587);

                Color grayColor = Color.FromArgb(grayscale, grayscale, grayscale);

                grayImgBitMap.SetPixel(i, j, grayColor);
            }
        }

        grayImgBitMap.Save("../../converted.jpg");
    }
}
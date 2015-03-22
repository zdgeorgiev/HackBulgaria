using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;

class ListDuplicatingFiles
{
    static List<FileInfo> allFiles;

    static void Main(string[] args)
    {
        Console.Write("Enter path: ");
        string path = Console.ReadLine();

        DirectoryInfo dir = new DirectoryInfo(path);
        if (!dir.Exists)
        {
            Console.WriteLine("Directory doesn't exist");
            return;
        }

        allFiles = new List<FileInfo>();

        try
        {
            GetAllFilesFrom(path);
            FilterTheFiles();
        }
        catch (Exception)
        {
            //Escape the directories or files for which access is denied
        }


        StringBuilder output = new StringBuilder();
        output.Append("[");

        foreach (var file in allFiles)
        {
            output.Append(@"'" + file.Name + @"', ");
        }

        output.Length -= 2;
        output.Append("]");

        Console.WriteLine(output.ToString());
    }

    private static void FilterTheFiles()
    {
        for (int i = 0; i < allFiles.Count - 1; i++)
        {
            for (int j = i + 1; j < allFiles.Count; j++)
            {
                if (CheckForSameContent(allFiles[i], allFiles[j]))
                {
                    allFiles.RemoveAt(j);
                }
            }
        }
    }

    private static bool CheckForSameContent(FileInfo fileInfo1, FileInfo fileInfo2)
    {
        FileStream fs1;
        FileStream fs2;

        fs1 = new FileStream(fileInfo1.FullName, FileMode.Open, FileAccess.Read);
        fs2 = new FileStream(fileInfo2.FullName, FileMode.Open, FileAccess.Read);

        if (fs1.Length != fs2.Length)
        {
            fs1.Close();
            fs2.Close();

            return false;
        }

        int file1Bytes;
        int file2Bytes;

        do
        {
            file1Bytes = fs1.ReadByte();
            file2Bytes = fs2.ReadByte();
        }
        while ((file1Bytes == file2Bytes) && (file1Bytes != -1));

        return ((file1Bytes - file2Bytes) == 0);
    }

    private static void GetAllFilesFrom(string path)
    {
        var folders = Directory.GetDirectories(path);

        foreach (var file in Directory.GetFiles(path))
        {
            allFiles.Add(new FileInfo(file));
        }

        if (Directory.GetDirectories(path).Count() == 0)
        {
            return;
        }

        foreach (var folder in folders)
        {
            GetAllFilesFrom(folder);
        }
    }
}
package stackInvatiant;

import stackLinkedList.Item;
import stackLinkedList.StackImpl;

public class StackInvariant extends StackImpl {
    public StackInvariant() {
    }

    @Override
    public void push(Item next) {

        // Check if contains already
        boolean isExist = false;
        Item headCpy = super.obj;
        while (headCpy != null) {
            // Comparing through values not references!
            if (headCpy.getValue().equals(next.getValue())) {
                System.out.println("Item " + next.getValue() + " already exist in the stack");
                isExist = true;
                break;
            }

            headCpy = (Item) headCpy.getPrev();
        }

        super.push(next);
    }
}

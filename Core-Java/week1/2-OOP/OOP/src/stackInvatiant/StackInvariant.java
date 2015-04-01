package stackInvatiant;

import stackLinkedList.Item;
import stackLinkedList.StackImpl;

public class StackInvariant extends StackImpl {
    public StackInvariant() {
        super();
    }

    @Override
    public void push(Item next) {
        // Check if contains already
        boolean isExist = false;
        Item headCpy = this.pop();
        while (headCpy != null) {
            // Comparing through values not references!
            if (headCpy.getValue().equals(next.getValue())) {
                System.out.println("Item " + next.getValue() + " already exist in the stack");
                isExist = true;
                break;
            }

            headCpy = (Item) headCpy.getPrev();
        }

        if (!isExist) {
            super.push(next);
        }
    }
}

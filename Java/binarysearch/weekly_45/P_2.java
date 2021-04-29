package binarysearch.weekly_45;

@SuppressWarnings({ "InnerClassMayBeStatic", "unused" })
public class P_2 {

    class VirtuallyCloneableStacks {
        int[] size;
        int idx = 1;

        VirtuallyCloneableStacks() {
            size = new int[(int) (1e5 + 5)];
        }

        public void copyPush(int i) {
            size[idx++] = size[i] + 1;
        }

        public void copyPop(int i) {
            size[idx++] = size[i] - 1;
        }

        public int size(int i) {
            return size[i];
        }
    }
}

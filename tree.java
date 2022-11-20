public class tree {
    static int[] leftPart = new int[10];
    
    static int leftIndex=0;
    static String result="";
    static String result2="";
    public static void main(String[] params) {
        Tree root =
                new Tree (1, 
                    new Tree(2, 
                        new Tree (4, 
                            new Tree(7), 
                                new Tree (9)), null), 
                    new Tree (3, 
                        new Tree(5), 
                            new Tree(6, 
                                new Tree(11), new Tree(20))));
        
        System.out.println("Сумма дерева: " + root.sum());
        System.out.println(root.value+result);
        System.out.println(result2);
        // System.out.println(result);
    }

    static class Tree {
        int value;
        Tree left;
        Tree right;

        public Tree(int value, Tree left, Tree right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Tree(int value) {
            this.value = value;
        }

        public int sum() {
            int summ = value;

            if (left != null) {

                System.out.println(left.value);
                leftPart[leftIndex]=left.value;
                leftIndex+=1;
                result2+="("+left.value+",";
                if (right==null){
                    System.out.println("null)");
                    leftIndex-=1;
                    result+="("+leftPart[leftIndex]+","+"null)";
                    result2+="null)";
                    
                }
                summ += left.sum();

            }

            if (right != null) {

                System.out.println(right.value);
                leftIndex-=1;
                result2+=right.value+")";
                if (leftIndex>=0) {
                    result+= "("+leftPart[leftIndex]+","+right.value+")";   
                }
                summ += right.sum();
            }
            return summ;
        }
    }
}
// Xinghan Guo 
// A QuestionNode class is used for a single node of a binary tree of Strings(Questions or answers)

public class QuestionNode {
    public String data; // top of tree
    public QuestionNode left; // subtree of yes
    public QuestionNode right;// subtree of no
    
    // constructs an answer node with given data
    public QuestionNode(String data) {
        this(data, null, null);
    }
    
    // constructs a question node with given data, left "yes" node, and right "no" node
    public QuestionNode(String data, QuestionNode left, QuestionNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}

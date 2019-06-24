package tree;

//二叉树
public class BiTree {
	private BiTreeNode root;

	public BiTree() {
		this.root = null;
	}

	public BiTree(BiTreeNode root) {
		super();
		this.root = root;
	}
	//由根遍历和中根遍历序列创建二叉树算法
	public BiTree(String preOrder, String inOrder, int preIndex, int inIndex, int count) {

	}
	//由标明空子树的先根遍历序列创建二叉树算法
	private static int index = 0;
	public BiTree(String preStr) {
		
	}
	//先根遍历二叉树基本操作的递归算法
	public void preRootTraverse(BiTreeNode T) {
		if(T != null) {
			System.out.println(T.getData());//答应根节点内容
			preRootTraverse(T.getLeftChild());//遍历左子节点
			preRootTraverse(T.getRightChild());//遍历右子节点
		}
	}
	//先根遍历的费递归算法
	public void preRootTraverseCommon(BiTreeNode T) {
		
	}

}

package tree;
//二叉链表表达树
public class BiTreeNode {
	private Object data;
	private BiTreeNode leftChild, rightChild;

	public BiTreeNode() {
		this(null);
	}

	public BiTreeNode(Object data) {
		this(data, null, null);
	}

	public BiTreeNode(Object data, BiTreeNode leftChild, BiTreeNode rightChild) {
		this.data = data;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public BiTreeNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(BiTreeNode leftChild) {
		this.leftChild = leftChild;
	}

	public BiTreeNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(BiTreeNode rightChild) {
		this.rightChild = rightChild;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("BiTreeNode [data= ");
		if (data == null) {
			sb.append("null");
		} else {
			sb.append(data.toString());
		}
		sb.append(", leftChild=" + leftChild.toString() + ", rightChild=" + rightChild.toString() + "]");
		return sb.toString();
	}

}

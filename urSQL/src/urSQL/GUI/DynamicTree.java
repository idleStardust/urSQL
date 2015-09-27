package urSQL.GUI;

/*
 * This code is based on an example provided by Richard Stanford,
 * a tutorial reader.
 */

import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

/**
 * A JTree in a JPanel.
 * 
 * @author Manuel Mora
 */

public class DynamicTree extends JPanel {
	/** serial id */
	private static final long serialVersionUID = 1L;
	private DefaultMutableTreeNode raiz;
	private DefaultTreeModel treeModel;
	private JTree tree;
	private Toolkit toolkit = Toolkit.getDefaultToolkit();

	public DynamicTree(DefaultMutableTreeNode rootNode) {
		super(new GridLayout(1, 0));

		this.raiz = rootNode;
		treeModel = new DefaultTreeModel(rootNode);
		tree = new JTree(treeModel);
		tree.setEditable(true);
		tree.getSelectionModel().setSelectionMode(
				TreeSelectionModel.SINGLE_TREE_SELECTION);
		tree.setShowsRootHandles(true);

		JScrollPane scrollPane = new JScrollPane(tree);
		add(scrollPane);
	}

	/** Remove all nodes except the root node. */
	public void clear() {
		raiz.removeAllChildren();
		treeModel.reload();
	}

	/** Remove the currently selected node. */
	public void removeCurrentNode() {
		TreePath currentSelection = tree.getSelectionPath();
		if (currentSelection != null) {
			DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode) (currentSelection
					.getLastPathComponent());
			MutableTreeNode parent = (MutableTreeNode) (currentNode.getParent());
			if (parent != null) {
				treeModel.removeNodeFromParent(currentNode);
				return;
			}
		}

		// Either there was no selection, or the root was selected.
		toolkit.beep();
	}

	/** Add child to the currently selected node. */
	public DefaultMutableTreeNode addObject(Object child) {
		DefaultMutableTreeNode parentNode = null;
		TreePath parentPath = tree.getSelectionPath();

		if (parentPath == null) {
			parentNode = raiz;
		} else {
			parentNode = (DefaultMutableTreeNode) (parentPath
					.getLastPathComponent());
		}

		return addObject(parentNode, child, true);
	}

	public DefaultMutableTreeNode addObject(DefaultMutableTreeNode parent,
			Object child) {
		return addObject(parent, child, false);
	}

	public DefaultMutableTreeNode addObject(DefaultMutableTreeNode parent,
			Object child, boolean shouldBeVisible) {
		DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(child);

		if (parent == null) {
			parent = raiz;
		}

		// It is key to invoke this on the TreeModel, and NOT
		// DefaultMutableTreeNode
		treeModel.insertNodeInto(childNode, parent, parent.getChildCount());

		// Make sure the user can see the lovely new node.
		if (shouldBeVisible) {
			tree.scrollPathToVisible(new TreePath(childNode.getPath()));
		}
		return childNode;
	}
	public void esquemaTree(DynamicTree treePanel) {
		String bebe[][][]={{{"Base de Datos1"}},{ {"Tabla"},{"nom_col1","nom_col2"},{"noref1","nom_ref2"},{"nom_con1","nom_con2"}},{ {"Tabla2"},{"nom_col1","nom_col2"},{"noref1","nom_ref2"},{"nom_con1","nom_con2"}}};
		String p0Name = new String(bebe[0][0][0]);
		DefaultMutableTreeNode p1, p2,p3, p4,p0;
		p0 = treePanel.addObject(null, p0Name);
		int j=1;
		while(j !=bebe.length){
		String p1Name = new String(bebe[j][0][0]);
		String p2Name = new String("Columnas");
		String p3Name = new String("Referencias");
		String p4Name = new String("Constrains");
		
		p1=treePanel.addObject(p0, p1Name);
		
		p2 = treePanel.addObject(p1, p2Name);
		p3= treePanel.addObject(p1, p3Name);
		p4=treePanel.addObject(p1, p4Name);
		int i=0;
		while(i !=bebe[j][1].length){
			
			String c1Name = new String(bebe[j][1][i]);
			treePanel.addObject(p2, c1Name);
			i++;
		}	
		i=0;
		while(i!=bebe[j][2].length){
			
			String c1Name = new String(bebe[j][2][i]);
			treePanel.addObject(p3, c1Name);
			i++;
		}
		i=0;
		while(i!=bebe[j][3].length){
			
			String c1Name = new String(bebe[j][3][i]);
			treePanel.addObject(p4, c1Name);
			i++;
		}j++;	
	}
		j=0;
		}


}

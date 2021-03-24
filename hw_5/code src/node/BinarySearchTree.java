package node;

import java.util.Date;

public class BinarySearchTree {

    private Node data;
    private BinarySearchTree left;
    private BinarySearchTree right;

    public BinarySearchTree() {
        this( null );
    }

    public BinarySearchTree( Node data ) {
        this.data = data;
        this.left = this.right = null;
    }

    public void insert( Node aNode ) {
        if ( aNode.isLess( data ) )       {
            if ( left == null )
                left = new BinarySearchTree( aNode );
            else
                left.insert( aNode );
        }
        else {
            if ( right == null )
                right = new BinarySearchTree( aNode );
            else
                right.insert( aNode );
        }
    }

    public BinarySearchTree find( Node aNode ) {
        if ( aNode.isEqual( data ) ) return this;

        if ( this.left != null && aNode.isLess( data ) )
            return left.find( aNode );

        if ( this.right != null && aNode.isGreater( data ) )
            return right.find( aNode );

        return null;
    }

    public void printInorder() {
        if ( left != null ) left.printInorder();
        System.out.print( data.toString() + " " );
        if ( right != null ) right.printInorder();
    }

    public void printPostOrder() {
        if ( left != null ) left.printPostOrder();
        if ( right != null ) right.printPostOrder();
        System.out.print( data.toString() + " " );
    }

    public void printPreOrder() {
        System.out.print( data.toString() + " " );
        if ( left != null ) left.printPreOrder();
        if ( right != null ) right.printPreOrder();
    }

    public static void main( String args[] )      {
        /*BinarySearchTree aBS = new BinarySearchTree( new StringNode( "d" ) );

        aBS.insert( new StringNode( "b" ) );  //            d
        aBS.insert( new StringNode( "a" ) );  //      b          f
        aBS.insert( new StringNode( "c" ) );  //    a   c      e   g
        aBS.insert( new StringNode( "f" ) );  //
        aBS.insert( new StringNode( "e" ) );  //
        aBS.insert( new StringNode( "g" ) );  //

        // Try the traversals

        // Inorder output should be:  a b c d e f g

        System.out.print( "Inorder:\t" );
        aBS.printInorder();
        System.out.println();

        // Postorder output should be:  a c b e g f d

        System.out.print( "Postorder:\t" );
        aBS.printPostOrder();
        System.out.println();

        // Preorder output should be:  d b a c f e g

        System.out.print( "Preorder:\t" );
        aBS.printPreOrder();
        System.out.println();

        // Try looking for some stuff

        if ( aBS.find( new StringNode( "d" ) ) != null )
            System.out.println( "found d" );
        if ( aBS.find( new StringNode( "a" ) ) != null )
            System.out.println( "found a" );
        if ( aBS.find( new StringNode( "g" ) ) != null )
            System.out.println( "found g" );
        if ( aBS.find( new StringNode( "x" ) ) != null )
            System.out.println( "found x" );*/

        Date d = new Date();
        String time = d.toString();
        System.out.println(time);
    }

} // BinaryTree


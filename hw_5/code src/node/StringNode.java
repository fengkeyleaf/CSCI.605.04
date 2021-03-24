package node;

public class StringNode implements Node {

    private String info;

    public StringNode( String info ) {
        this.info = info;
    }

    public boolean isLess( Node aNode ) {
//        return ( info.compareTo( aSNode.info ) < 0 );// wrong
        return ( info.compareTo( ((StringNode)aNode).info ) < 0 );// wrong
    }

    public boolean isGreater( Node aNode ) {
        StringNode aStringNode = ( StringNode )aNode;

        return ( info.compareTo( aStringNode.info ) > 0 );
    }

    public boolean isEqual( Node aNode ) {
        StringNode aStringNode = ( StringNode )aNode;

        return ( info.compareTo( aStringNode.info ) == 0 );
    }

    public String toString() {
        return ( info );
    }
}
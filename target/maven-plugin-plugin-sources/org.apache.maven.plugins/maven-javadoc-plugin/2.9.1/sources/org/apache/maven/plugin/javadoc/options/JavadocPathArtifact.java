/*
 =================== DO NOT EDIT THIS FILE ====================
 Generated by Modello 1.4.1 on 2013-06-25 10:59:19,
 any modifications will be overwritten.
 ==============================================================
 */

package org.apache.maven.plugin.javadoc.options;

/**
 * An artifact object used by Javadoc path options like -docletpath
 * or -tagletpath.
 * 
 * @version $Revision$ $Date$
 */
@SuppressWarnings( "all" )
public class JavadocPathArtifact
    implements java.io.Serializable
{

      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The id of the group of the artifact.
     */
    private String groupId;

    /**
     * The id of the artifact.
     */
    private String artifactId;

    /**
     * The version of the artifact.
     */
    private String version;


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method equals.
     * 
     * @param other
     * @return boolean
     */
    public boolean equals( Object other )
    {
        if ( this == other )
        {
            return true;
        }

        if ( !( other instanceof JavadocPathArtifact ) )
        {
            return false;
        }

        JavadocPathArtifact that = (JavadocPathArtifact) other;
        boolean result = true;

        result = result && ( getGroupId() == null ? that.getGroupId() == null : getGroupId().equals( that.getGroupId() ) );
        result = result && ( getArtifactId() == null ? that.getArtifactId() == null : getArtifactId().equals( that.getArtifactId() ) );
        result = result && ( getVersion() == null ? that.getVersion() == null : getVersion().equals( that.getVersion() ) );

        return result;
    } //-- boolean equals( Object )

    /**
     * Get the id of the artifact.
     * 
     * @return String
     */
    public String getArtifactId()
    {
        return this.artifactId;
    } //-- String getArtifactId()

    /**
     * Get the id of the group of the artifact.
     * 
     * @return String
     */
    public String getGroupId()
    {
        return this.groupId;
    } //-- String getGroupId()

    /**
     * Get the version of the artifact.
     * 
     * @return String
     */
    public String getVersion()
    {
        return this.version;
    } //-- String getVersion()

    /**
     * Method hashCode.
     * 
     * @return int
     */
    public int hashCode()
    {
        int result = 17;

        result = 37 * result + ( groupId != null ? groupId.hashCode() : 0 );
        result = 37 * result + ( artifactId != null ? artifactId.hashCode() : 0 );
        result = 37 * result + ( version != null ? version.hashCode() : 0 );

        return result;
    } //-- int hashCode()

    /**
     * Set the id of the artifact.
     * 
     * @param artifactId
     */
    public void setArtifactId( String artifactId )
    {
        this.artifactId = artifactId;
    } //-- void setArtifactId( String )

    /**
     * Set the id of the group of the artifact.
     * 
     * @param groupId
     */
    public void setGroupId( String groupId )
    {
        this.groupId = groupId;
    } //-- void setGroupId( String )

    /**
     * Set the version of the artifact.
     * 
     * @param version
     */
    public void setVersion( String version )
    {
        this.version = version;
    } //-- void setVersion( String )

    /**
     * Method toString.
     * 
     * @return String
     */
    public java.lang.String toString()
    {
        StringBuilder buf = new StringBuilder( 128 );

        buf.append( "groupId = '" );
        buf.append( getGroupId() );
        buf.append( "'" );
        buf.append( "\n" ); 
        buf.append( "artifactId = '" );
        buf.append( getArtifactId() );
        buf.append( "'" );
        buf.append( "\n" ); 
        buf.append( "version = '" );
        buf.append( getVersion() );
        buf.append( "'" );

        return buf.toString();
    } //-- java.lang.String toString()

}

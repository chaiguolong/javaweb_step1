package org.omg.CosNaming;


/**
* org/omg/CosNaming/NameHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from /HUDSON3/workspace/8-2-build-macosx-x86_64/jdk8u101/7261/corba/src/share/classes/org/omg/CosNaming/nameservice.idl
* Wednesday, June 22, 2016 2:43:37 AM PDT
*/


/**
   * A name is a sequence of name components.
   */
public final class NameHolder implements org.omg.CORBA.portable.Streamable
{
  public org.omg.CosNaming.NameComponent value[] = null;

  public NameHolder ()
  {
  }

  public NameHolder (org.omg.CosNaming.NameComponent[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = org.omg.CosNaming.NameHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    org.omg.CosNaming.NameHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return org.omg.CosNaming.NameHelper.type ();
  }

}

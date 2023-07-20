package org.stellar.sdk;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

import org.junit.Assert;
import org.junit.Test;

public class BumpFootprintExpirationOperationTest {
  @Test
  public void testBuilderWithSource() {
    String source = "GASOCNHNNLYFNMDJYQ3XFMI7BYHIOCFW3GJEOWRPEGK2TDPGTG2E5EDW";
    BumpFootprintExpirationOperation op =
        new BumpFootprintExpirationOperation.Builder(123).setSourceAccount(source).build();
    assertEquals(123, op.getLedgersToExpire());
    assertEquals(source, op.getSourceAccount());
    String expectXdr = "AAAAAQAAAAAk4TTtavBWsGnEN3KxHw4Ohwi22ZJHWi8hlamN5pm0TgAAABkAAAAAAAAAew==";
    assertEquals(expectXdr, op.toXdrBase64());
  }

  @Test
  public void testBuilderWithoutSource() {
    BumpFootprintExpirationOperation op = new BumpFootprintExpirationOperation.Builder(123).build();
    assertEquals(123, op.getLedgersToExpire());
    assertNull(op.getSourceAccount());
    String expectXdr = "AAAAAAAAABkAAAAAAAAAew==";
    assertEquals(expectXdr, op.toXdrBase64());
  }

  @Test
  public void testFromXdr() {
    String source = "GASOCNHNNLYFNMDJYQ3XFMI7BYHIOCFW3GJEOWRPEGK2TDPGTG2E5EDW";
    BumpFootprintExpirationOperation originOp =
        new BumpFootprintExpirationOperation.Builder(123).setSourceAccount(source).build();
    org.stellar.sdk.xdr.Operation xdrObject = originOp.toXdr();
    Operation restartOp = Operation.fromXdr(xdrObject);
    Assert.assertEquals(restartOp, originOp);
  }

  @Test
  public void testEquals() {
    String source = "GASOCNHNNLYFNMDJYQ3XFMI7BYHIOCFW3GJEOWRPEGK2TDPGTG2E5EDW";
    BumpFootprintExpirationOperation operation1 =
        new BumpFootprintExpirationOperation.Builder(123).setSourceAccount(source).build();
    BumpFootprintExpirationOperation operation2 =
        new BumpFootprintExpirationOperation.Builder(123).setSourceAccount(source).build();
    assertEquals(operation1, operation2);
  }

  @Test
  public void testNotEquals() {
    String source = "GASOCNHNNLYFNMDJYQ3XFMI7BYHIOCFW3GJEOWRPEGK2TDPGTG2E5EDW";
    BumpFootprintExpirationOperation operation1 =
        new BumpFootprintExpirationOperation.Builder(123).setSourceAccount(source).build();
    BumpFootprintExpirationOperation operation2 =
        new BumpFootprintExpirationOperation.Builder(124).setSourceAccount(source).build();
    Assert.assertNotEquals(operation1, operation2);
  }

  @Test
  public void testNotEqualsSource() {
    String source = "GASOCNHNNLYFNMDJYQ3XFMI7BYHIOCFW3GJEOWRPEGK2TDPGTG2E5EDW";
    BumpFootprintExpirationOperation operation1 =
        new BumpFootprintExpirationOperation.Builder(123).setSourceAccount(source).build();
    BumpFootprintExpirationOperation operation2 =
        new BumpFootprintExpirationOperation.Builder(123).build();
    Assert.assertNotEquals(operation1, operation2);
  }
}

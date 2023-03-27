package org.feng.jnr.dynamic;

import jnr.ffi.byref.ByteByReference;
import jnr.ffi.byref.IntByReference;

public interface ModelicaStandardTablesUsertab {
    int USERTAB_NAME(ByteByReference tableName, int nipo, int[] dim, IntByReference colWise, double[][] table);
}

package com.wenboy;

import java.io.*;

public class App {
    public static void main(String args[]) {
        String data1[] = {"import \"import3.seal\";",
                "",
                "const bool c2 = true;"};

        String data2[] = {"const bool c2 = true;",
                "group import3:",
                "  const bool c3 = true;",
                "end"};
        String result=unifiedPrint("data1",data1,"data2",data2);
        System.out.println(result);
        //输出结果可在 https://diffy.org/ 进行结构化显示
    }
    public static String unifiedPrint(String oldDataName,String[] oldData,String newDataName,String[] newData) {

        Diff d = new Diff(oldData, newData);
        Diff.change rslt = d.diff_2(false);
        DiffPrint.UnifiedPrint dp = new DiffPrint.UnifiedPrint(oldData,newData);
        StringWriter sw = new StringWriter();
        dp.setOutput(sw);
        dp.print_header(oldDataName, newDataName);
        dp.print_script(rslt);
        return sw.toString();
    }
}

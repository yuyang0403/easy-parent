package com.yuyang.easy.customer;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class UtilsTest {


    private void readFile(File file){
        if(file.exists()&&file.isDirectory()){
            //获取文件列表
            File [] files=file.listFiles();
            if(files!=null&&files.length>0){
                for (int i = 0; i < files.length; i++) {
                    File everyFile=files[i];
                    if(everyFile.isDirectory()){
                        readFile(everyFile);
                    }else{
                        if(everyFile.getName().contains("equ")) {
                            System.out.println(everyFile.getName().replaceAll("\\.equ", "") + "\t`" + everyFile.getAbsolutePath() + "`");
                        }
                    }
                }
            }
        }else{
            if(file.getName().contains("equ")) {
                System.out.println(file.getName().replaceAll("\\.equ", "") + "\t`" + file.getAbsolutePath() + "`");
            }
        }
    }

    private void renameFile(File file){
        if(file.exists()&&file.isDirectory()){
            //获取文件列表
            File [] files=file.listFiles();
            if(files!=null&&files.length>0){
                for (int i = 0; i < files.length; i++) {
                    File everyFile=files[i];
                    if(everyFile.isDirectory()){
                        renameFile(everyFile);
                    }else{
                       File newFile=new File(everyFile.getParent()+"/1"+everyFile.getName());
                       System.out.println(everyFile.renameTo(newFile));
                    }
                }
            }
        }else{
            File newFile=new File(file.getParent()+"/1"+file.getName());
            System.out.println(file.renameTo(newFile));
        }
    }

    /**
     * 根据文件列表生成lst
     */
    @Test
    public void whileFileList(){
        String filePath="E:\\DNF\\完美安图恩\\Script\\equipment";
        File directory=new File(filePath);
        readFile(directory);
    }

    @Test
    public void whileRenameFile(){
        String filePath="E:\\DNF\\完美安图恩\\Script\\equipment";
        File directory=new File(filePath);
        renameFile(directory);
    }


    /**
     * 针对文件替换内容
     * @throws Exception
     */
    @Test
    public void updateFileContent()throws Exception{
        String filePath="E:\\DNF\\86\\Script\\equipment\\creature";
        File d1=new File(filePath);
        File[] d2=d1.listFiles();
        for (int i = 0; i < d2.length; i++) {
            File [] f3=d2[i].listFiles();
            for (int j = 0; j < f3.length; j++) {
                File everyFile=f3[j];
                InputStream is=new FileInputStream(everyFile);
                InputStreamReader isr = new InputStreamReader(is, "UTF-8");
                // 使用 BufferedReader 进行读取
                List<String> lines=FileUtils.readLines(everyFile,"utf-8");
                for (int k = 0; k < lines.size(); k++) {
                    String line=lines.get(k);
                    if(line.equals("[part set index]")){
                        lines.set(k+1,lines.get(k+1).replaceAll("11\t","11"));
                    }
                }
                System.out.println(filePath+"\\"+d2[i].getName()+"\\"+everyFile.getName());
                FileUtils.writeLines(new File(filePath+"\\"+d2[i].getName()+"\\"+everyFile.getName()),lines);
            }
        }
    }

}

//Alexander Howes
import java.util.*;
import java.io.*;
public class application2 extends queue2 {
        
public static int[] csvbust(String[] changer) {
    int[] thisarray = new int[65535];
    String stringholder= "y";
    String testforcomma="y";
    int index=0;
    int i;
    for(int linecrawl=0;linecrawl<changer.length;linecrawl++) {
        if(changer[linecrawl]==null){
            break;
        }
        stringholder=changer[linecrawl];
        String [] parts = stringholder.split(",");
        for (i=0; i<parts.length; i++) {
            testforcomma=parts[i];
            index++;
            if((!testforcomma.equals("")) && (testforcomma!=null)) {
                thisarray[index-1] = Integer.parseInt(parts[i]);
            }
            else{
                break;
            }
        }
    }
    int[]finalarray = new int[index];
    for(i=0;i<index;i++){
        finalarray[i]=thisarray[i];
    }
  return finalarray;
}

public static void main(String args[]) {
    queue2 myqueue = new queue2 ();
    decode2 decoder = new decode2 ();
    if(args.length==0) {
        System.out.println("No command line arguments found");
        return;
    }
    FileReader fr;
    FileReader frtwo;
    try{
        fr = new FileReader(args[0]);
        BufferedReader buffread = new BufferedReader(fr);
        String[] datachanger = new String[20];
        int buffcrawl;
        String plug="y";        
        for(buffcrawl=0;plug!=null;buffcrawl++){
            plug = buffread.readLine();
            datachanger[buffcrawl]=plug;
        }            
        int [] bustedarray = csvbust(datachanger);
        int crawler;
        int answer;
            for(crawler=0;crawler<bustedarray.length;crawler++) {
                answer=bustedarray[crawler];
                myqueue.loadValue(answer);
            }
        crawler=0;
        answer=0;
        buffcrawl=0;
        plug="y";
        frtwo = new FileReader(args[1]);
        BufferedReader secbuffread = new BufferedReader(frtwo);
        String [] codeschanger = new String[50];
        plug = secbuffread.readLine();
        for(buffcrawl=0;plug!=null;buffcrawl++){
            codeschanger[buffcrawl]=plug;
            plug = secbuffread.readLine();
        }
        int [] secbustedarray = csvbust(codeschanger);
        for(crawler=0;crawler<secbustedarray.length;crawler++) {
            answer=secbustedarray[crawler];
            secbustedarray[crawler]=answer;
        }
        int i;
        queue2 outputdata = decode2.decoder(myqueue, secbustedarray);
        String s;
        byte b[];
        FileOutputStream out = new FileOutputStream("File.txt");
        String comma=",";
    String[] send = new String[outputdata.size()+1];
    for(i=0;i<=send.length;i++){
    if(outputdata.isEmpty()==true){break;}
    else{
    s=String.valueOf(outputdata.nextValue());
        send[i]=s;
    }
        for(i=0;i<send.length;i++){
            if(send[i+1]==null){
            s=send[i];
            b=s.getBytes();
            out.write(b);
                break;
            }
            else{
            s=send[i];
            b=s.getBytes();
            out.write(b);
            s=comma;
            b=s.getBytes();
            out.write(b);
            }
        }
    buffread.close();
    fr.close();
    secbuffread.close();
    frtwo.close();
    out.close();
    }
        catch (Exception e) { 
            System.err.println(e.getMessage());
        }
    }
}
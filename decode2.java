//Alexander Howes
public class decode2{
public static queue2 decoder(queue2 data, int[] codes) {
    queue2 output = new queue2 ();
    data.normalize();
    int pik = data.size();
    int [] dataarray = data.peek(pik);
    int noise=0;
    int count = 0;
    String str = "";
    int i=0;
    int successes=0;
    int [] eachcode = new int[codes.length*2];
    int [] indexs   = new int[codes.length*2];
    int [] sources  = new int[codes.length*2];
    String [] counter  = new String[codes.length*2];
    int[] secindex = new int [codes.length*2];
    for (i= 0;i < codes.length;i++){
        if(i==codes.length-1){
            sources[count]=codes[i+1];
            indexs[count]=i+1;
            secindex[count]=i;
            counter[count]=String.valueOf(sources[count]);
            count++;
            break;
        }
        if(codes[i]>codes[i+1]){
            sources[count]=codes[i+1];
            indexs[count]= i+1;
            secindex[count]=i;
            counter[count]=String.valueOf(sources[count]);
            count ++;
            i++;
        }
    }
    int p=0;
    String sm="y";
        for(i=0;i<counter.length;i++){
            if(sm==null){
                break;
            }
            else{
                p++;
                sm=counter[i+1];
            }
        }
    count = 0;
    int bigcrawl;
    int crawler=0;
    int lengthofeachcode=0;
    int getindex=0;
    for(bigcrawl=0;bigcrawl<p;bigcrawl++){
        while(codes[crawler]!=sources[bigcrawl]){
            eachcode[crawler]=codes[crawler];
            crawler++; 
        }
        lengthofeachcode=indexs[getindex];
        getindex++;
        noise=0;
            for(i=0;i<=dataarray.length;i++){
                if(noise==2){
                    count=lengthofeachcode+1;
                    break;
                }
                if(count==lengthofeachcode){
                    output.loadValue(sources[bigcrawl]);
                    count=count+2;
                    successes++;
                    break;
                }
                if(dataarray[i]>eachcode[count]){
                    noise++;
                    count++;
                }   
                if(dataarray[i]==eachcode[count]){
                    count++;
                    
                }
            }
    }
    return output;
    }
}
public class Calculations {
    private String o1="",o2="",result="";
   private  int toggleFocus;
   private Operations op=Operations.CLEAR;

    Calculations() {

    }

    public void setO1(String s1){
       if(s1=="")
           o1=s1;
        o1+=s1;

    }

    public void setO2(String s2){
        if (s2=="")
            o2=s2;
        o2+=s2;
    }

    public void setResult(String s2){
        result=s2;
    }
    public void setToggleFocus(int i){
        toggleFocus=i;
    }
    public void setOp(Operations o){
        op=o;
    }

    public String getO1(){
        return o1;
    }
    public String getO2(){
        return o2;
    }
    public String getResult(){
        return result;
    }
    public int getToggleFocus(){
        return toggleFocus;
    }
    public Operations getOp(){
        return op;
    }

}

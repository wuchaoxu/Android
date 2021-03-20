package swu.edu.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

public class Calculators extends AppCompatActivity implements View.OnClickListener {
//    String TAG="test";
//    private Map<Integer, String> map = new HashMap<>();
//    private String s = "";

    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, button_doc;
    Button button_mu, button_add, button_sub, button_chu;
    Button button_delete, button_output;
    Button clear_text;
    EditText result;
    boolean flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calulators);
        button0 =  findViewById(R.id.button0);
        button1 =  findViewById(R.id.button1);
        button3 =  findViewById(R.id.button3);
        button2 =  findViewById(R.id.button2);
        button4 =  findViewById(R.id.button4);
        button5 =  findViewById(R.id.button5);
        button6 =  findViewById(R.id.button6);
        button7 =  findViewById(R.id.button7);
        button8 =  findViewById(R.id.button8);
        button9 =  findViewById(R.id.button9);
        button_doc =  findViewById(R.id.button_doc);
        button_add =  findViewById(R.id.button_add);
        button_sub =  findViewById(R.id.button_sub);
        button_mu =  findViewById(R.id.button_mu);
        button_chu =  findViewById(R.id.button_chu);
        button_delete =  findViewById(R.id.button_delete);
        button_output = findViewById(R.id.button_output);
        clear_text = findViewById(R.id.clear_text);
        result = findViewById(R.id.wcx);

        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button_doc.setOnClickListener(this);
        button_add.setOnClickListener(this);
        button_sub.setOnClickListener(this);
        button_mu.setOnClickListener(this);
        button_chu.setOnClickListener(this);
        button_output.setOnClickListener(this);
        button_delete.setOnClickListener(this);
        clear_text.setOnClickListener(this);
    }

//        map.put(R.id.button0,"0");
//        map.put(R.id.button1,"1");
//        map.put(R.id.button2,"2");
//        map.put(R.id.button3,"3");
//        map.put(R.id.button4,"4");
//        map.put(R.id.button5,"5");
//        map.put(R.id.button6,"6");
//        map.put(R.id.button7,"7");
//        map.put(R.id.button8,"8");
//        map.put(R.id.button9,"9");
//        map.put(R.id.button_doc,".");
//        map.put(R.id.button_mu,"*");
//        map.put(R.id.button_add,"+");
//        map.put(R.id.button__,"-");
//        map.put(R.id.button_chu,"/");

//    public void onClick(View view){
//        Log.i(TAG, "onClick: onClick");
//        s += map.get(view.getId());
//        TextView viewById = view.findViewById(R.id.wcx);
//        Log.i(TAG, "onClick: onClick"+viewById.getId());
//    }
//
//    public void delete(View view) {
//        s = s.substring(0, s.length()-1);
//    }
//
//    public void equ(View view){
//        Log.i(TAG, "onClick: equ");
//        Log.i(TAG, "onClick: "+view.getId());
//        System.out.println(s);
//        TextView viewById = (TextView)view.findViewById(R.id.text);
//        viewById.setText("计算完毕+"+s);
//
//    }



          public void onClick(View v) {
            String str = result.getText().toString();  //获取文本框中的文本内容
        switch (v.getId()){
            case   R.id.button0:
            case   R.id.button1:
            case   R.id.button2:
            case   R.id.button3:
            case   R.id.button4:
            case   R.id.button5:
            case   R.id.button6:
            case   R.id.button7:
            case   R.id.button8:
            case   R.id.button9:
            case   R.id.button_doc:
                if(flag){
                    flag=false;
                    str="";
                    result.setText("");
                }
                result.setText(str+((Button)v).getText());
                break;
            case R.id.button_add:
            case R.id.button_chu:
            case R.id.button_sub:
            case R.id.button_mu:
                if(flag){
                    flag = false;
                    str="";
                    result.setText("");
                }
                if(str.contains("+")||str.contains("-")||str.contains("×")||str.contains("%")) {
                    str=str.substring(0,str.indexOf(" "));  //截取字符串
                }
                result.setText(str+" "+((Button)v).getText()+" ");
                break;
            case R.id.button_delete:
                if(flag)
                    flag=false;
                str="";
                result.setText("");
                break;
            case R.id.button_output: //单独运算最后结果
                getResult();//调用下面的方法
                break;
            case R.id.clear_text:
                if(flag)
                    flag=false;
                str="";
                result.setText("");
                break;
        }
    }

        private void getResult(){
            String exp = result.getText().toString();
            if (exp == null || exp.equals("")) return;
            //因为没有运算符所以不用运算
            if (!exp.contains(" ")) {
                return;
            }
            if (flag) {
                flag = false;
                return;
            }
            flag = true;
            //截取运算符前面的字符串
            String s1 = exp.substring(0, exp.indexOf(" "));
            //截取的运算符
            String op = exp.substring(exp.indexOf(" ") + 1, exp.indexOf(" ") + 2);
            //System.out.println("op = " + op);
            //截取运算符后面的字符串
            String s2 = exp.substring(exp.indexOf(" ") + 3);
            double cnt = 0;
            if (!s1.equals("") && !s2.equals("")) {
                double d1 = Double.parseDouble(s1);
                double d2 = Double.parseDouble(s2);
                System.out.println("d1 = "+ d1);
                System.out.println("d2 = "+ d2);
                if (op.equals("+")) {
                    cnt = d1 + d2;
                }
                if (op.equals("-")) {
                    cnt = d1 - d2;
                }
                if (op.equals("x")) {
                    cnt = d1 * d2;
                    System.out.println("cnt = " + cnt);
                }
                if (op.equals("%")) {
                    if (d2 == 0) cnt = 0;
                    else cnt = d1 / d2;
                    //System.out.println("cnt = " + cnt);
                }
                if (!s1.contains(".") && !s2.contains(".") && !op.equals("÷")) {
                   // int res =  cnt;
                    result.setText(cnt + "");
                } else {
                    result.setText(cnt + "");
                }
            }
            //如果s1不是空    s2是空  就执行下一步
            else if (!s1.equals("") && s2.equals("")) {
                double d1 = Double.parseDouble(s1);
                if (op.equals("+")) {
                    cnt = d1;
                }
                if (op.equals("-")) {
                    cnt = d1;
                }
                if (op.equals("×")) {
                    cnt = 0;
                }
                if (op.equals("÷")) {
                    cnt = 0;
                }
                if (!s1.contains(".")) {
                    int res = (int) cnt;
                    result.setText(res + "");
                } else {
                    result.setText(cnt + "");
                }
            }
            //如果s1是空    s2不是空  就执行下一步
            else if (s1.equals("") && !s2.equals("")) {
                double d2 = Double.parseDouble(s2);
                if (op.equals("+")) {
                    cnt = d2;
                }
                if (op.equals("-")) {
                    cnt = 0 - d2;
                }
                if (op.equals("×")) {
                    cnt = 0;
                }
                if (op.equals("÷")) {
                    cnt = 0;
                }
                if (!s2.contains(".")) {
                    int res = (int) cnt;
                    result.setText(res + "");
                } else {
                    result.setText(cnt + "");
                }
            } else {
                result.setText("");
            }
        }
    }





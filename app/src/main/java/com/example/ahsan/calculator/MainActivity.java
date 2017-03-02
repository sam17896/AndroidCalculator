package com.example.ahsan.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button zero,one,two,three,four,five,six,seven,eight,nine,
            plus,minus,divide,multiply,
            cancel,backspace,equal,bracket,sign,decimal;
    TextView tv;
    int brack = 0;
    double ans = 0;
    boolean ob,cb,eq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        configuration();
    }

    private void configuration() {
        zero        = (Button) findViewById(R.id.zero);
        one         = (Button) findViewById(R.id.one);
        two         = (Button) findViewById(R.id.two);
        three       = (Button) findViewById(R.id.three);
        four        = (Button) findViewById(R.id.four);
        five        = (Button) findViewById(R.id.five);
        six         = (Button) findViewById(R.id.six);
        seven       = (Button) findViewById(R.id.seven);
        eight       = (Button) findViewById(R.id.eight);
        nine        = (Button) findViewById(R.id.nine);
        cancel      = (Button) findViewById(R.id.cancel);
        plus        = (Button) findViewById(R.id.plus);
        minus       = (Button) findViewById(R.id.minus);
        divide      = (Button) findViewById(R.id.divide);
        multiply    = (Button) findViewById(R.id.multiply);
        backspace   = (Button) findViewById(R.id.backspace);
        equal       = (Button) findViewById(R.id.equal);
        bracket     = (Button) findViewById(R.id.brackets);
        sign        = (Button) findViewById(R.id.sign);
        decimal     = (Button) findViewById(R.id.decimal);
        tv          = (EditText) findViewById(R.id.textView);
        ob          = false;
        cb          = false;
        eq          = false;
        zero.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        divide.setOnClickListener(this);
        multiply.setOnClickListener(this);
        backspace.setOnClickListener(this);
        equal.setOnClickListener(this);
        bracket.setOnClickListener(this);
        sign.setOnClickListener(this);
        decimal.setOnClickListener(this);
        cancel.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void clear()
    {
        tv.setText("");
        brack = 0;
        ans = 0;
        ob = cb = eq = false;
    }
    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch(id)
        {
            case R.id.zero:
                if(eq) {
                    clear();
                }
                String t = tv.getText().toString();
                if(t.length()==0) {
                    tv.append("0");
                    break;
                }
                char c = t.charAt(t.length()-1);
                if(tv.getText().length()!=1||c!='0')
                tv.append("0");
                break;
            case R.id.one:
                if(eq) {
                    clear();
                }
                tv.append("1");
                break;
            case R.id.two:
                if(eq) {
                    clear();
                }
                tv.append("2");
                break;
            case R.id.three:
                if(eq) {
                    clear();
                }
                tv.append("3");
                break;
            case R.id.four:
                if(eq) {
                    clear();
                }
                tv.append("4");
                break;
            case R.id.five:
                if(eq) {
                    clear();
                }
                tv.append("5");
                break;
            case R.id.six:
                if(eq) {
                    clear();
                }
                tv.append("6");
                break;
            case R.id.seven:
                if(eq) {
                    clear();
                }
                tv.append("7");
                break;
            case R.id.eight:
                if(eq) {
                    clear();
                }
                tv.append("8");
                break;
            case R.id.nine:
                if(eq) {
                    clear();
                }
                tv.append("9");
                break;
            case R.id.cancel:
                clear();
                break;
            case R.id.plus:
                if(eq) {
                    eq = false;
                    tv.setText("");
                    tv.append(Double.toString(ans));
                }
                tv.append("+");
                break;
            case R.id.minus:
                if(eq) {
                    eq = false;
                    tv.setText("");
                    tv.append(Double.toString(ans));
                }
                tv.append("-");
                break;
            case R.id.multiply:
                if(eq) {
                    eq = false;
                    tv.setText("");
                    tv.append(Double.toString(ans));
                }
                tv.append("*");
                break;
            case R.id.divide:
                if(eq) {
                    eq = false;
                    tv.setText("");
                    tv.append(Double.toString(ans));
                }
                tv.append("/");
                break;
            case R.id.sign:
                break;
            case R.id.brackets:
                if(eq){
                    clear();
                }
                if(tv.getText().length()<1) {
                    tv.append("(");
                    brack++;
                    ob = true;
                }
                else if(!ob&&!cb)
                {
                    t = tv.getText().toString();
                    c = t.charAt(t.length() - 1);
                    if((c>47&&c<58)||(c==')'))
                    tv.append("*(");
                    else
                    tv.append("(");
                    brack++;
                    ob = true;
                }
                else if(ob)
                {
                    t = tv.getText().toString();
                    c = t.charAt(t.length() - 1);
                    if(c>47&&c<58)
                    {
                        tv.append(")");
                        brack--;
                        if(brack==0)
                        ob = false;
                    }
                    else if(c=='(')
                    {
                        tv.append("(");
                        brack++;
                    }
                    else if (c==')')
                    {
                        tv.append(")");
                        brack--;
                        if(brack==0)
                        ob = false;
                    }
                    else if(c=='+'||c=='-'||c=='*'||c=='/')
                    {
                        tv.append("(");
                        brack++;
                    }
                    else
                    {
                        tv.append("*(");
                        brack++;
                    }
                }
                break;
            case R.id.decimal:
                if(eq) {
                    clear();
                }
                tv.append(".");
                break;
            case R.id.backspace:
                if(eq){
                    clear();
                }
                t = tv.getText().toString();
                if(t.length()>0)
                {
                    if((t.charAt(t.length()-1))=='(')
                    {
                        brack--;
                        if(brack==0)
                            ob = false;
                    }
                    if((t.charAt(t.length()-1))==')')
                    {
                        brack++;
                    }
                    t = t.substring(0, t.length() - 1);
                }
                tv.setText("");
                tv.append(t);
                break;
            case R.id.equal:
                String text = tv.getText().toString();
                if(eq) {
                    break;
                }
                if(text.length()>0) {
                    Solver obj = new Solver();
                    String p = obj.convertion(text);
                    if (check(text)) {
                        ans = obj.solve(p);
                    } else {
                        Toast.makeText(this, "Syntax Error", Toast.LENGTH_LONG).show();
                        break;
                    }
                    tv.append(" = " + ans);
                    eq = true;
                }
                    break;

        }

    }

    private boolean check(String p) {
        char prev = ' ';
        char curr;
        int ob = 0 , cb = 0;
        if(p.charAt(p.length()-1)=='+'||p.charAt(p.length()-1)=='/'||p.charAt(p.length()-1)=='*'||p.charAt(p.length()-1)=='-')
            return false;
        if(p.charAt(0)=='*'||p.charAt(0)=='/')
            return false;
        for(int i=0 ; i < p.length() ; i++)
        {
            curr = p.charAt(i);
            if(curr == '(') {
                ob++;
                continue;
            }
            else if(curr == ')'){
                cb++;
                continue;
            }
            else if(curr == '+' || curr == '-' || curr == '*' || curr == '/' || curr == '.')
            {
                if(prev == curr)
                    return false;
            }
            else if((curr > 64 && curr < 69)||(curr > 69 && curr < 91)||(curr > 96 && curr < 123))
            {
                return false;
            }
            prev = curr;
        }
        return ob == cb;
    }
}

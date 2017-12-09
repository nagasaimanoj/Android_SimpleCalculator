package com.blogspot.gnsmk.simplecalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    TextView tvOutput;
    String strPwd = "";
    int operation = 0, floatCount = 1;
    Double a = 0.0, i = 0.0;
    boolean isFloat = false, isFloatTemp = false, isPwdOn = false; //I am bad with naming

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Calculator Beta", Toast.LENGTH_SHORT).show();
        tvOutput = (TextView) findViewById(R.id.tvOutput);
        setOutput(0.0);
    }

    public void tempFun(View view) {
        //this is for all beta functions
        isPwdOn = !isPwdOn;
    }

    public void setOutput(Double output) {
        if (!isFloat) {
            tvOutput.setText("" + output.intValue());
        } else
            tvOutput.setText("" + output);
    }

    public double getOutput() {
        return Double.parseDouble(tvOutput.getText().toString());
    }

    public void addValue(int x) {
        floatCount++;
        if (!isFloatTemp) {
            setOutput((Double.parseDouble(tvOutput.getText().toString()) * 10) + x);
        } else {
            floatCount++;
            setOutput(Double.parseDouble(tvOutput.getText().toString()) + (x / floatCount));
        }
    }

    public void btnBcs(View view) {
        if (!isFloatTemp) {
            setOutput((getOutput() - (getOutput() % 10)) / 10);
        } else {
            Toast.makeText(this, "not working", Toast.LENGTH_SHORT).show();
        }
    }

    public void btnAc(View view) {
        a = i = 0.0;
        setOutput(0.0);
    }

    public void btn0(View view) {
        if (!isPwdOn) {
            addValue(0);
        } else {
            strPwd = strPwd + "0";
        }
    }

    public void btn1(View view) {
        if (!isPwdOn) {
            addValue(1);
        } else {
            strPwd = strPwd + "1";
        }
    }

    public void btn2(View view) {
        if (!isPwdOn) {
            addValue(2);
        } else {
            strPwd = strPwd + "2";
        }
    }

    public void btn3(View view) {
        if (!isPwdOn) {
            addValue(3);
        } else {
            strPwd = strPwd + "3";
        }
    }

    public void btn4(View view) {
        if (!isPwdOn) {
            addValue(4);
        } else {
            strPwd = strPwd + "4";
        }
    }

    public void btn5(View view) {
        if (!isPwdOn) {
            addValue(5);
        } else {
            strPwd = strPwd + "5";
        }
    }

    public void btn6(View view) {
        if (!isPwdOn) {
            addValue(6);
        } else {
            strPwd = strPwd + "6";
        }
    }

    public void btn7(View view) {
        if (!isPwdOn) {
            addValue(7);
        } else {
            strPwd = strPwd + "7";
        }
    }

    public void btn8(View view) {
        if (!isPwdOn) {
            addValue(8);
        } else {
            strPwd = strPwd + "8";
        }
    }

    public void btn9(View view) {
        if (!isPwdOn) {
            addValue(9);
        } else {
            strPwd = strPwd + "9";
        }
    }

    public void btnSign(View view) {
        setOutput(-(getOutput()));
    }

    public void btnPlus(View view) {
        operation(1);
    }

    public void btnMinus(View view) {
        operation(2);
    }

    public void btnStar(View view) {
        operation(3);
    }

    public void btnSlash(View view) {
        operation(4);
    }

    public void btnPercentage(View view) {
        operation(5);
    }

    public void btnDot(View view) {
        isFloatTemp = true;
        operation(0);
        isFloat = !isFloat;
        setOutput(a);
    }

    public void btnEqual(View view) {
        operation(0);
    }

    public void operation(int op) {
        //thank you for reading this comment. I really mean it
        if (!isPwdOn) {
            switch (operation) {
                case 0:
                    a = getOutput();
                    setOutput(a);
                    break;
                case 1:
                    a += getOutput();
                    break;
                case 2:
                    a -= getOutput();
                    break;
                case 3:
                    a *= getOutput();
                    break;
                case 4:
                    a /= getOutput();
                    break;
                case 5:
                    a %= getOutput();
                    break;
                default:
                    Toast.makeText(this, "Something really seems wrong here", Toast.LENGTH_SHORT).show();
                    break;
            }
            setOutput(0.0);
            operation = op;
            isFloatTemp = false;
        } else {
            if (strPwd != "") //intent should be added later
                strPwd = "";
            isPwdOn = false;
        }
    }
}
package com.example.beautysalon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button premiumBtn, goldBtn, silverBtn, nonMbBtn, clearBtn;
    TextView servicePriceText, productPriceText, discountServiceText, discountProductText, totalText;
    CheckBox haircutCheck, colorCheck, shaveCheck, shampooCheck, creamCheck, gelCheck;
    Price price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        price = new Price();

        premiumBtn = findViewById(R.id.premiumButton);
        goldBtn = findViewById(R.id.goldButton);
        silverBtn = findViewById(R.id.silverButton);
        nonMbBtn = findViewById(R.id.nonMemberButton);
        clearBtn = findViewById(R.id.clearButton);

        servicePriceText = findViewById(R.id.servicePriceText);
        productPriceText = findViewById(R.id.productPriceText);
        discountServiceText = findViewById(R.id.discountServiceText);
        discountProductText = findViewById(R.id.discountProductText);
        totalText = findViewById(R.id.totalPriceDisplayText);

        haircutCheck = findViewById(R.id.haircutCheckBox);
        colorCheck = findViewById(R.id.colorCheckBox);
        shaveCheck = findViewById(R.id.shaveCheckBox);

        shampooCheck = findViewById(R.id.shampooCheckBox);
        creamCheck = findViewById(R.id.creamCheckBox);
        gelCheck = findViewById(R.id.gelCheckBox);

        premiumBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setColorForClickedBtn(premiumBtn);
                setColorForUnclickedBtn(goldBtn, silverBtn, nonMbBtn);
                price.serviceDiscount = 20;
                price.productDiscount = 10;
                updateDiscount();
                updateTotalPrice();
            }
        });

        goldBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setColorForClickedBtn(goldBtn);
                setColorForUnclickedBtn(premiumBtn, silverBtn, nonMbBtn);
                price.serviceDiscount = 15;
                price.productDiscount = 10;
                updateDiscount();
                updateTotalPrice();
            }
        });

        silverBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setColorForClickedBtn(silverBtn);
                setColorForUnclickedBtn(premiumBtn, goldBtn, nonMbBtn);
                price.serviceDiscount = 10;
                price.productDiscount = 10;
                updateDiscount();
                updateTotalPrice();
            }
        });

        nonMbBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setColorForClickedBtn(nonMbBtn);
                setColorForUnclickedBtn(premiumBtn, goldBtn, silverBtn);
                price.resetDiscount();
                updateDiscount();
                updateTotalPrice();
            }
        });

        haircutCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(haircutCheck.isChecked()) updateServicePrice(25);
                else updateServicePrice(-25);
            }
        });

        colorCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(colorCheck.isChecked()) updateServicePrice(58);
                else updateServicePrice(-58);
            }
        });

        shaveCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(shaveCheck.isChecked()) updateServicePrice(12);
                else updateServicePrice(-12);
            }
        });

        shampooCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(shampooCheck.isChecked()) updateProductPrice(10);
                else updateProductPrice(-10);
            }
        });

        creamCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(creamCheck.isChecked()) updateProductPrice(27.5);
                else updateProductPrice(-27.5);
            }
        });

        gelCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(gelCheck.isChecked()) updateProductPrice(13);
                else updateProductPrice(-13);
            }
        });

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(getIntent());
            }
        });

        nonMbBtn.performClick();
    }

    public void setColorForClickedBtn(Button btn){
        btn.setBackground(getDrawable(R.drawable.roundclickedbtn));
    }

    public void setColorForUnclickedBtn(Button btn1, Button btn2, Button btn3){
        btn1.setBackground(getDrawable(R.drawable.roundbtn));
        btn2.setBackground(getDrawable(R.drawable.roundbtn));
        btn3.setBackground(getDrawable(R.drawable.roundbtn));
    }

    public void updateServicePrice(double p){
        price.servicePrice += p;
        servicePriceText.setText("" + (price.servicePrice));
        updateDiscount();
        updateTotalPrice();
    }

    public void updateProductPrice(double p){
        price.productPrice += p;
        productPriceText.setText("" + (price.productPrice));
        updateDiscount();
        updateTotalPrice();
    }

    public void updateDiscount(){
        discountServiceText.setText("" + ((price.servicePrice * price.serviceDiscount / 100)));
        discountProductText.setText("" + (price.productPrice * price.productDiscount / 100));
    }

    public void updateTotalPrice(){
        totalText.setText(""+ ((price.servicePrice+price.productPrice) -
                ((price.servicePrice * price.serviceDiscount / 100)+(price.productPrice * price.productDiscount / 100))));
    }
}

package com.example.aplikacjaczcionka;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private SeekBar fontSizeSeekBar;
    private TextView quoteText;
    private Button changeQuoteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fontSizeSeekBar = findViewById(R.id.fontSizeSeekBar);
        quoteText = findViewById(R.id.quoteText);
        changeQuoteButton = findViewById(R.id.changeQuoteButton);

        fontSizeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // Aktualizacja tekstu na podstawie postępu suwaka
                quoteText.setTextSize(progress); // Ustawienie rozmiaru czcionki cytatu
                updateFontSizeLabel(progress); // Aktualizacja etykiety "Rozmiar:"
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        String[] quotes = {"Dzień dobry", "Good morning", "Buenos dias"};
        final int[] currentQuoteIndex = {0};

        changeQuoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Zmiana cytatu po kliknięciu przycisku
                currentQuoteIndex[0] = (currentQuoteIndex[0] + 1) % quotes.length;
                quoteText.setText(quotes[currentQuoteIndex[0]]);
            }
        });
    }

    // Metoda do aktualizacji etykiety "Rozmiar:"
    private void updateFontSizeLabel(int fontSize) {
        TextView fontSizeLabel = findViewById(R.id.fontSizeLabel);
        fontSizeLabel.setText("Rozmiar: " + fontSize);
    }
}

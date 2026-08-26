package com.example.rgbtextwatcher;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.rgbtextwatcher.databinding.ActivityMainBinding;

import java.util.Locale;

public final class MainActivity extends AppCompatActivity implements TextWatcher {
    private ActivityMainBinding binding;
    private boolean normalizingInput;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.redInput.addTextChangedListener(this);
        binding.greenInput.addTextChangedListener(this);
        binding.blueInput.addTextChangedListener(this);
        renderColor();
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        // Not needed for this exercise.
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        // afterTextChanged sees the final editable value.
    }

    @Override
    public void afterTextChanged(Editable editable) {
        if (normalizingInput || binding == null) {
            return;
        }
        normalizeIfTooHigh(binding.redInput);
        normalizeIfTooHigh(binding.greenInput);
        normalizeIfTooHigh(binding.blueInput);
        renderColor();
    }

    private void normalizeIfTooHigh(EditText input) {
        String raw = input.getText().toString();
        if (raw.isEmpty()) {
            return;
        }
        try {
            int parsed = Integer.parseInt(raw);
            if (parsed <= RgbChannel.MAX) {
                return;
            }
        } catch (NumberFormatException exception) {
            return;
        }

        normalizingInput = true;
        input.setText(String.valueOf(RgbChannel.MAX));
        input.setSelection(input.length());
        normalizingInput = false;
    }

    private void renderColor() {
        int red = RgbChannel.parseClamped(binding.redInput.getText().toString());
        int green = RgbChannel.parseClamped(binding.greenInput.getText().toString());
        int blue = RgbChannel.parseClamped(binding.blueInput.getText().toString());
        int color = Color.rgb(red, green, blue);
        binding.colorPreview.setBackgroundColor(color);
        binding.colorValue.setText(getString(
                R.string.color_value,
                red,
                green,
                blue,
                String.format(Locale.ROOT, "%02X%02X%02X", red, green, blue)
        ));
    }

    @Override
    protected void onDestroy() {
        binding = null;
        super.onDestroy();
    }
}

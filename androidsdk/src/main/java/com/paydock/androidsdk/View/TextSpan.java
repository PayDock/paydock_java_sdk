package com.paydock.androidsdk.View;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.style.ReplacementSpan;

public class TextSpan extends ReplacementSpan {

    private final String mText;

    TextSpan(String text) {
        super();
        this.mText = text;
    }

    @Override
    public int getSize(@NonNull Paint paint, CharSequence charSequence, @IntRange(from = 0) int start, @IntRange(from = 0) int end, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        float character = paint.measureText(mText, 0, mText.length());
        float textSize = paint.measureText(charSequence, start, end);
        return (int) (character + textSize);
    }

    @Override
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, @IntRange(from = 0) int start, @IntRange(from = 0) int end, float x, int top, int y, int bottom, @NonNull Paint paint) {
        canvas.drawText(charSequence.subSequence(start, end) + mText , x, y, paint);
    }


}

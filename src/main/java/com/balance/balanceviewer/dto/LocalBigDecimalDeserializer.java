package com.balance.balanceviewer.dto;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.math.BigDecimal;

public class LocalBigDecimalDeserializer extends JsonDeserializer<BigDecimal> {

    @Override
    public BigDecimal deserialize(JsonParser parser, DeserializationContext context)
            throws IOException {
        String bigDecimalString = parser.getText();
        if (bigDecimalString.contains(",")) {
            bigDecimalString = bigDecimalString.replace(",", ".");
        }
        return new BigDecimal(bigDecimalString);
    }
}

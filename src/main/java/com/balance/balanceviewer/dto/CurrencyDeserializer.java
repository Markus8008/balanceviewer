package com.balance.balanceviewer.dto;

import com.balance.balanceviewer.model.CurrencyType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class CurrencyDeserializer extends JsonDeserializer<CurrencyType> {

    @Override
    public CurrencyType deserialize(JsonParser parser, DeserializationContext context)
            throws IOException {
        return CurrencyType.valueOf(parser.getText());
    }
}

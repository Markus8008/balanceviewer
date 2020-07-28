package com.balance.balanceviewer.dto;

import com.balance.balanceviewer.model.TransactionType;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class TransactionTypeDeserializer extends JsonDeserializer<TransactionType> {

    @Override
    public TransactionType deserialize(JsonParser parser, DeserializationContext context)
            throws IOException {
        return TransactionType.valueOf(parser.getText().toUpperCase());
    }
}

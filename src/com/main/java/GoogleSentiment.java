package com.main.java;

import com.google.api.services.language.v1.model.Document;
import com.google.api.services.language.v1.model.Sentiment;
import com.google.cloud.language.v1.LanguageServiceClient;
import com.twilio.sdk.resource.instance.lookups.PhoneNumber.Type;

public class GoogleSentiment {

	public static void main(String... args) throws Exception {
		// Instantiates a client
		LanguageServiceClient language = LanguageServiceClient.create();

		// The text to analyze
		String text = "Hello, world!";
//		Document doc = Document.newBuilder().setContent(text).setType(Type.PLAIN_TEXT).build();

		// Detects the sentiment of the text
		//Sentiment sentiment = language.analyzeSentiment(doc).getDocumentSentiment();

		System.out.printf("Text: %s%n", text);
		//System.out.printf("Sentiment: %s, %s%n", sentiment.getScore(), sentiment.getMagnitude());
	}

}

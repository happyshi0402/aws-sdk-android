/*
 * Copyright 2010-2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.amazonaws.services.lambda.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.http.JsonErrorResponseHandler.JsonErrorResponse;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers.*;
import com.amazonaws.transform.*;
import com.amazonaws.util.json.AwsJsonReader;

import com.amazonaws.services.lambda.model.ENILimitReachedException;

public class ENILimitReachedExceptionUnmarshaller extends JsonErrorUnmarshaller {

    public ENILimitReachedExceptionUnmarshaller() {
        super(ENILimitReachedException.class);
    }

    @Override
    public boolean match(JsonErrorResponse error) throws Exception {
        return error.getErrorCode().equals("ENILimitReachedException");
    }

    @Override
    public AmazonServiceException unmarshall(JsonErrorResponse error) throws Exception {

        ENILimitReachedException e = (ENILimitReachedException) super.unmarshall(error);
        e.setErrorCode("ENILimitReachedException");
        e.setType(String.valueOf(error.get("Type")));

        return e;
    }

    public ENILimitReachedException unmarshall(JsonUnmarshallerContext context) throws Exception {
        AwsJsonReader reader = context.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }

        // The `getMessage` method of AWSServiceException derives its value from
        // `errorMessage`. The incoming context
        // has the value in `message`, so we'll have a special case to handle
        // that.
        ENILimitReachedException eNILimitReachedException = new ENILimitReachedException(
                "No message provided.");
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if ("message".equals(name)) {
                eNILimitReachedException.setErrorMessage(StringJsonUnmarshaller.getInstance()
                        .unmarshall(context));
            } else if (name.equals("Type")) {
                eNILimitReachedException.setType(StringJsonUnmarshaller.getInstance().unmarshall(
                        context));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return eNILimitReachedException;
    }
}

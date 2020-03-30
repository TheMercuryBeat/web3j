/*
 * Copyright 2019 Web3 Labs Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package org.web3j.abi.datatypes;

import java.util.List;

import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.FunctionReturnDecoder;
import org.web3j.abi.TypeReference;

import static org.web3j.abi.Utils.convert;

/** Function type. */
public class Function {
    private final String name;
    private final List<Type<?>> inputParameters;
    private final List<TypeReference<Type<?>>> outputParameters;

    public Function(
            final String name,
            final List<Type<?>> inputParameters,
            final List<TypeReference<?>> outputParameters) {
        this.name = name;
        this.inputParameters = inputParameters;
        this.outputParameters = convert(outputParameters);
    }
    
    public String encoded() {
        return FunctionEncoder.encode(this);
    }
    
    public List<Type<?>> decode(final String response) {
        return FunctionReturnDecoder.decode(response, getOutputParameters());
    }

    public String getName() {
        return name;
    }

    public List<Type<?>> getInputParameters() {
        return inputParameters;
    }

    public List<TypeReference<Type<?>>> getOutputParameters() {
        return outputParameters;
    }
}

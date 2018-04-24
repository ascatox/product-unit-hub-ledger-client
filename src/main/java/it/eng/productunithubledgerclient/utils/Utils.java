/*
 *
 *  Copyright 2016,2017 DTCC, Fujitsu Australia Software Technology, IBM - All Rights Reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package it.eng.productunithubledgerclient.utils;


import it.eng.productunithubledgerclient.exception.ProductUnitHubException;
import it.eng.productunithubledgerclient.model.ChassisDTO;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;

import javax.validation.ConstraintViolation;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.Security;
import java.security.spec.InvalidKeySpecException;
import java.util.Set;

import static java.lang.String.format;

public class Utils {
    private final static Logger logger = LogManager.getLogger(Utils.class);


    public static void getMessageViolations(Set<ConstraintViolation<ChassisDTO>> violations) throws ProductUnitHubException {
        if (violations.isEmpty())
            return ;
        StringBuilder messageBuilder = new StringBuilder();
        for (ConstraintViolation violation : violations) {
            messageBuilder.append(violation.getMessage());
        }
        if (StringUtils.isNotEmpty(messageBuilder.toString()))
            throw new ProductUnitHubException(messageBuilder.toString());
    }

    public static File findFileSk(String domainName, String user, String cryptoDir) {
        File directory = getSkConfigPath(domainName,user, cryptoDir);

        File[] matches = directory.listFiles((dir, name) -> name.endsWith("_sk"));

        if (null == matches) {
            throw new RuntimeException(format("Matches returned null does %s directory exist?", directory
                    .getAbsoluteFile().getName()));
        }

        if (matches.length != 1) {
            throw new RuntimeException(format("Expected in %s only 1 sk file but found %d", directory.getAbsoluteFile
                    ().getName(), matches.length));
        }
        return matches[0];
    }

    public static File getSkConfigPath(String domainName, String user, String cryptoDir) {
        return Paths.get(cryptoDir,
                "/peerOrganizations/",
                domainName, format("/users/"+user+"@%s/msp/keystore", domainName))
                .toFile();
    }

    public static File getCertConfigPath(String domainName, String user, String cryptoDir) {
        return Paths.get(cryptoDir, "/peerOrganizations/",
                domainName,
                format("/users/Admin@%s/msp/signcerts/"+user+"@%s-cert.pem", domainName,
                        domainName)).toFile();
    }




    public static PrivateKey getPrivateKeyFromBytes(byte[] data) throws IOException, NoSuchProviderException,
            NoSuchAlgorithmException, InvalidKeySpecException {
        final Reader pemReader = new StringReader(new String(data));

        final PrivateKeyInfo pemPair;
        try (PEMParser pemParser = new PEMParser(pemReader)) {
            pemPair = (PrivateKeyInfo) pemParser.readObject();
        }
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());

        PrivateKey privateKey = new JcaPEMKeyConverter().setProvider(BouncyCastleProvider.PROVIDER_NAME)
                .getPrivateKey(pemPair);

        return privateKey;
    }


}

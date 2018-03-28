package it.eng.productunithubledgerclient.api.config;

import it.eng.productunithubledgerclient.api.exception.ProductUnitHubException;
import it.eng.productunithubledgerclient.api.helper.ChannelInitializationManager;
import it.eng.productunithubledgerclient.utils.Utils;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hyperledger.fabric.sdk.HFClient;
import org.hyperledger.fabric.sdk.exception.InvalidArgumentException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;

/**
 * @author ascatox
 */
public class UserManager {
    private final static Logger log = LogManager.getLogger(UserManager.class);

    //TODO Singleton
    private static UserManager instance;
    private Configuration configuration;
    private Organization organization;

    private UserManager(Configuration configuration, Organization organization) {
        this.configuration = configuration;
        this.organization = organization;
    }

    public static UserManager getInstance(Configuration configuration, Organization organization) throws ProductUnitHubException, InvalidArgumentException {
        if (instance == null || !instance.organization.equals(organization)) { //1
            synchronized (ChannelInitializationManager.class) {
                if (instance == null) {  //2
                    instance = new UserManager(configuration, organization);
                }
            }
        }
        return instance;
    }

    public User getMember(String name) throws ProductUnitHubException {
        try {
            User user = new User();
            user.setMspId(organization.getMspID());
            File certConfigPath = Utils.getCertConfigPath(organization.getDomainName(), name, configuration.getCryptoconfigdir());
            String certificate = new String(IOUtils.toByteArray(new FileInputStream(certConfigPath)), ConfigManager.UTF_8);
            File fileSk = Utils.findFileSk(organization.getDomainName(), name, configuration.getCryptoconfigdir());

            PrivateKey privateKey = Utils.getPrivateKeyFromBytes(IOUtils.toByteArray(new FileInputStream(fileSk)));
            user.setEnrollment(new Enrollment(privateKey, certificate));

            return user;
        } catch (IOException | NoSuchAlgorithmException | NoSuchProviderException | InvalidKeySpecException | ClassCastException e) {
            log.error(e);
            throw new ProductUnitHubException(e);

        }
    }



}

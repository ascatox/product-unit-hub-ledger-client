package it.eng.productunithubledgerclient.api.config;

import it.eng.productunithubledgerclient.api.exception.ProductUnitHubException;
import it.eng.productunithubledgerclient.api.helper.ChannelInitializationManager;
import it.eng.productunithubledgerclient.utils.Utils;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hyperledger.fabric.sdk.exception.InvalidArgumentException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

/**
 * @author ascatox
 */
public class UserManager {
    private final static Logger log = LogManager.getLogger(UserManager.class);

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
                if (instance == null || !instance.organization.equals(organization)) {  //2
                    instance = new UserManager(configuration, organization);
                }
            }
        }
        return instance;
    }

    public void completeUsers(String name) throws ProductUnitHubException, NoSuchAlgorithmException, NoSuchProviderException, InvalidKeySpecException, IOException {
        //@See ascatox
        //FIXME control it's correct!!!
        Set<User> user = organization.getUsers();
        for (User users: user) {
            users = (User) doCompleteUser( name );
        }
/*
            Stream<User> userStream = organization.getUsers().stream();
            userStream.forEach(user -> {
                //@See ascatox
                //TODO with stream
            });
*/

    }

    private User doCompleteUser(String name) throws IOException, NoSuchProviderException, NoSuchAlgorithmException, InvalidKeySpecException {
        User user = new User();
        user.setName(name);
        user.setMspId(organization.getMspID());
        File certConfigPath = Utils.getCertConfigPath(organization.getDomainName(), name, configuration.getCryptoconfigdir());
        String certificate = new String(IOUtils.toByteArray(new FileInputStream(certConfigPath)), ConfigManager.UTF_8);
        File fileSk = Utils.findFileSk(organization.getDomainName(), name, configuration.getCryptoconfigdir());
        PrivateKey privateKey = Utils.getPrivateKeyFromBytes(IOUtils.toByteArray(new FileInputStream(fileSk)));
        user.setEnrollment(new Enrollment(privateKey, certificate));

        return user;
    }


}

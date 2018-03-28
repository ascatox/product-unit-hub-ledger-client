# Product Unit Hub LedgerClient
## Library for Hyperledger Fabric 1.1

**LedgerClient** is a **Java 8** library to interface with an [Hyperledger Fabric](https://hyperledger-fabric.readthedocs.io/en/latest/) blockchain using the [Hyperledger Fabric SDK Java](https://github.com/hyperledger/fabric-sdk-java).

The [Chaincode](https://github.com/ascatox/product-unit-hub-chaincode) in **Node** technology, to interact with the Product Unit Hub, will be released soon ⏰.
# FAR-EDGE Hosted Environment 
#### (Recommended solution)
In order to use the FAR-EDGE Hosted Env, you should **only** copy your HLF `crypto-config` folder (given) under the logged **USER HOME** directory and include `repositories` and `dependency` as shown below in your Maven `pom.xml`
```bash 
<repositories>
	<repository>
	    <id>jitpack.io</id>
	    <url>https://jitpack.io</url>
	</repository>
</repositories>
	
<dependency>
	<groupId>com.github.ascatox</groupId>
	<artifactId>product-unit-hub-ledger-client</artifactId>
	<version>master-SNAPSHOT</version>
</dependency>
```
# Developer Environment 
#### (Alternative solution)
## Setup HLF
In order to use the Library, launch Fabric as described in the [official docs](https://hyperledger-fabric.readthedocs.io/en/latest/) in the section [Writing your First Application](https://hyperledger-fabric.readthedocs.io/en/release-1.1/write_first_app.html).<br/>

### 💡Alternative solution --> `config-service-network` [installation guide](https://github.com/ascatox/configuration-network-fabric).

## Install and instantiate the chaincode
Information needed for install and instantiate the Chaincode are available [here](https://github.com/ascatox/product-unit-hub-chaincode).
## Configure the LedgerClient
Edit the file `config-network.json`[*](https://github.com/ascatox/product-unit-hub-ledger-client/blob/master/src/main/resources/config-network.json) with your favourite text editor in order to configure the network as in your HLF previous installation. Under you can find a complete example of configured file: <br/>
`vim config-network.json` 
```javascript
{
  "domainName": "fabric-network",
  "type": "hlfv1.1",
  "channelName": "ledgerchannel",
  "timeout": 3000,
  "cryptoconfigdir": "",
  "chaincode": {
    "path": "",
    "domainName": "product-unit-hub-chaincode",
    "version": "1.0",
    "lang": "NODE"
  },
  "organizations": [
    {
      "domainName":"org1.example.com", 
      "mspID": "Org1MSP",
      "peers": [
        {
          "domainName": "peer0.org1.example.com",
          "requestURL": "grpc://localhost:7051",
          "eventURL": "grpc://localhost:7053"
        }
      ],
      "ca": {
        "url": "http://localhost:7054",
        "domainName": "ca.example.com"
      },
      "orderers": [
        {
          "domainName":"orderer.example.com",
          "url": "grpc://localhost:7050"
        }
      ],
      "users":[
      {
        "name": "Admin"
      }
     ]
  ]
}
```

Copy your HLF `crypto-config` dir under the chosen directory (default directory is **USER HOME**), if you have problems look at [here](https://github.com/ascatox/configuration-network-fabric#troubleshooting). <br/>

### Maven projects
In order to use the library use Maven with these commands:
```bash
 mvn package && mvn install
```
# JavaDoc
The **JavaDoc** documentation of the Library, is present in the `doc` folder of the project.<br/>
Clone the project or download the [zip file](https://github.com/ascatox/product-unit-hub-ledger-client/blob/master/doc.zip) and open the `index.html` in the doc folder to explore the documentation, starting from `LedgerClient` and  `ChassisDTO`.

# Usage
You can find a simple example of usage looking at the **End2End tests** in the `test/integration` folder of project.

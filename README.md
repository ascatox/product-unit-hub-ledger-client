# ProductUnitHub LedgerClient library for Hyperledger Fabric 1.1

**LedgerClient** is a **Java 8** library to interface with an [Hyperledger Fabric](https://hyperledger-fabric.readthedocs.io/en/latest/) blockchain using the [Hyperledger Fabric SDK Java](https://github.com/hyperledger/fabric-sdk-java).

The Chaincode in Node Language, to interact with the Product Unit Hub, is released here.
# Setup HLF
In order to use the Library, launch Fabric as described in the [official docs](https://hyperledger-fabric.readthedocs.io/en/latest/) in the section [Writing your First Application](https://hyperledger-fabric.readthedocs.io/en/release/write_first_app.html).<br/>
# Install and instantiate the chaincode
```bash
TODO
```
### 💡Alternative solution --> `config-service-network` [installation guide](https://github.com/ascatox/configuration-network-fabric).

# Configure the LedgerClient
Edit the file `config-network.json`[*](https://github.com/far-edge/DistributedLedger/blob/develop/ledger-client/src/main/resources/config-network.properties) with your favourite text editor in order to configure the network as in your HLF previous installation. Under you can find a complete example of configured file: <br/>
`vim config-network.json` 
`
{
  "name": "fabric-network",
  "type": "hlfv1.1",
  "channelName": "ledgerchannel",
  "timeout": 3000,
  "cryptoconfigdir": "",
  "user":"admin",
  "chaincode": {
    "path": "",
    "name": "product-unit-hub-chaincode",
    "version": "1.0",
    "lang": "NODE"
  },
  "organizations": [
    {
      "mspID": "Org1MSP",
      "peers": [
        {
          "name": "peer0.org1.example.com",
          "requestURL": "grpc://localhost:7051",
          "eventURL": "grpc://localhost:7053"
        }
      ],
      "ca": {
        "url": "http://localhost:7054",
        "name": "ca.example.com"
      },
      "orderers": [
        {
          "name":"orderer.example.com",
          "url": "grpc://localhost:7050"
        }
      ]
    }
  ]
}

```

Copy your HLF `crypto-config` dir under the chosen directory (default directory is **USER HOME**), if you have problems [here](https://github.com/ascatox/configuration-network-fabric#troubleshooting). <br/>

### Maven

# JavaDoc
The **JavaDoc** documentation of the Library, is present in the `doc` folder of the project.<br/>
Clone the project or download the [zip file](https://github.com/far-edge/DistributedLedger/blob/develop/ledger-client/doc.zip) and open the `index.html` in the doc folder to explore the documentation, starting from `LedgerClient`.

# Usage
If your project uses maven, 
You can find simple [examples](https://github.com/far-edge/DistributedLedger/blob/develop/ledger-client/src/test/java/eu/faredge/smartledger/client/End2EndTestSmartLedgerClientDSM.java) of usage looking at the **End2End tests** in the `test` folder of project.

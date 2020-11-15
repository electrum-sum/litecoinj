/*
 * Copyright 2013 Google Inc.
 * Copyright 2015 Andreas Schildbach
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.sumcoinj.params;

import org.sumcoinj.core.*;
import org.sumcoinj.net.discovery.*;

import java.net.*;

import static com.google.common.base.Preconditions.*;

/**
 * Parameters for the main production network on which people trade goods and services.
 */
public class MainNetParams extends AbstractBitcoinNetParams {
    private int p2shHeader2;
    public static final int MAINNET_MAJORITY_WINDOW = 1000;
    public static final int MAINNET_MAJORITY_REJECT_BLOCK_OUTDATED = 950;
    public static final int MAINNET_MAJORITY_ENFORCE_BLOCK_UPGRADE = 750;

    public MainNetParams() {
        super();
        interval = INTERVAL;
        targetTimespan = TARGET_TIMESPAN;
        maxTarget = Utils.decodeCompactBits(0x1e0fffffL);
        addressHeader = 63; //sumcoin√ ∑
        dumpedPrivateKeyHeader = 128 + addressHeader;  //?
        p2shHeader = 5; //sumcoin√ ∑
        p2shHeader2 = 200; //sumcoin√ ∑

        acceptableAddressCodes = new int[] { addressHeader, p2shHeader,p2shHeader2 };
        port = 3333;  //sumcoin√ ∑
        packetMagic = 0xfac0b5d0l; //sumcoin√ ∑
        bip32HeaderPub = 0x0488b41c; //The 4 byte header that serializes in base58 to "xpub". //sumcoin√ ∑
        bip32HeaderPriv = 0x0488abe6; //The 4 byte header that serializes in base58 to "xprv" //sumcoin√ ∑

        majorityEnforceBlockUpgrade = MAINNET_MAJORITY_ENFORCE_BLOCK_UPGRADE;
        majorityRejectBlockOutdated = MAINNET_MAJORITY_REJECT_BLOCK_OUTDATED;
        majorityWindow = MAINNET_MAJORITY_WINDOW;

        genesisBlock.setDifficultyTarget(0x1e0ffff0L); //sumcoin√ ∑
        genesisBlock.setTime(1554579000L); //sumcoin√ ∑
        genesisBlock.setNonce(133964L); //sumcoin√ ∑
        id = ID_MAINNET;
        subsidyDecreaseBlockCount = 500000; //sumcoin√ ∑
        spendableCoinbaseDepth = 100;
        String genesisHash = genesisBlock.getHashAsString();
        checkState(genesisHash.equals("37d4696c5072cd012f3b7c651e5ce56a1383577e4edacc2d289ec9b25eebfd5e"),
                genesisHash);  //sumcoin√ ∑

        // This contains (at a minimum) the blocks which are not BIP30 compliant. BIP30 changed how duplicate
        // transactions are handled. Duplicated transactions could occur in the case where a coinbase had the same
        // extraNonce and the same outputs but appeared at different heights, and greatly complicated re-org handling.
        // Having these here simplifies block connection logic considerably.
        checkpoints.put(2800, Sha256Hash.wrap("31dfe91b64cbbb167b4e4c644ad7b008bb4bb8ca4e42aea02f938f445dc37cff"));
        checkpoints.put(5760, Sha256Hash.wrap("87de6e561bb0ab66095b272450cabbb0b11fb272e5ae37123ba1464a5de74f5c"));
        checkpoints.put(11520, Sha256Hash.wrap("0fcc3eacab1e532325f1c5bde0372b78e999a504a8eaaf3d4628038de6735d30"));
        checkpoints.put(28800, Sha256Hash.wrap("8c7fdd9dd713a964e09339593ca82a738135d6cd82421198311d7a3931742e04"));
        checkpoints.put(57600, Sha256Hash.wrap("edbe7a9e2e20c8c12fea25dc9be9268bfa308145fa68d2d2ce54dc405cf12e76"));
        checkpoints.put(115200, Sha256Hash.wrap("e386f62c30a46f6b565ffc8a3fdf73e5e76e9f2f400d5cba1911e7732b52bd8d"));
        checkpoints.put(201600, Sha256Hash.wrap("6bbde0a86b6e1efa71333bb3636f02931ebb872157b48c674efde25054a571b3"));
        checkpoints.put(400320, Sha256Hash.wrap("70de8d2e57f15f5e0b2e9abf603de8c788b0c7a77fe56011c78f582bfb0f131d"));
        checkpoints.put(1019520, Sha256Hash.wrap("ab7a59f310e2e86d81af0ca1f608d24127d8af934825c34ba3897eab1ab398cf"));
        checkpoints.put(1330560, Sha256Hash.wrap("be3a8b802886b0ae2f36e7bf225c11ae908b9e22756d6d981bc8e77a115d611a"));


        dnsSeeds = new String[] {
                "dnsseed.sumnode.io",
                "dnsseed.sumcoinpool.org",
                "dnsseed.sumcoin.space",
                "dnsseed.jandsmining.com",
                "sumdnsseed.moonypool.com",
                "dnsseed.sumcoinmining.org"
        };

        httpSeeds = new HttpDiscovery.Details[] {
                // Andreas Schildbach
//                new HttpDiscovery.Details(
//                        ECKey.fromPublicOnly(Utils.HEX.decode("0238746c59d46d5408bf8b1d0af5740fe1a6e1703fcb56b2953f0b965c740d256f")),
//                        URI.create("http://httpseed.bitcoin.schildbach.de/peers")
//                )
        };

        addrSeeds = new int[] {
                0x2d3f1d9e, 0x2e6524a4, 0x40e14aa3, 0x40e30b46, 0x40e340e1, 0x40e35149, 0x40e3656a, 0x43cd9412,
                0x43cdb131, 0x44b71775, 0x44b757bb, 0x44b78fc9, 0x44b7aa66, 0x44b7b4b8, 0x68f80ee0, 0x68f85c2d,
                0x80c71d1d, 0x80c71f8b, 0x80c7235b, 0x80c74e1c, 0x80c7519e, 0x80c76feb, 0x80c7756c, 0x80c7852c,
                0x80c78eb2, 0x80c7c44a, 0x80c7d733, 0x867a170d, 0x867a1a57, 0x867a6f6d, 0x867a767b, 0x867a7688,
                0x86d16eef, 0x86d1a735, 0x86d1adeb, 0x8a444f1e, 0x8ac5492e, 0x8ac58158, 0x8ac59041, 0x8ac59be4,
                0x8ac59cc1, 0x8ac5a0c3, 0x8b3b0597, 0x8b3b4f44, 0x8b3b9df6, 0x8e5d16d9, 0x8e5d687d, 0x8e5d7ac9,
                0x8e5d8e6f, 0x8e5d9b38, 0x8e5df5cb, 0x8f6e9f20, 0x9de60b85, 0x9de6617a, 0x9df50caf, 0x9df56768,
                0x9df5b9d9, 0x9f4148f9, 0x9f4155d3, 0x9f590d4f, 0x9f596954, 0x9f59a8d2, 0x9f59c0c0, 0x9fcb20f2,
                0x9fcb4aaf, 0x9fcb5365, 0x9fcb5e2a, 0x9fcb7bff, 0x9fcbb68e, 0xa002caa4, 0xa12305b1, 0xa12327e1,
                0xa12340ba, 0xa123e259, 0xa123e66a, 0xa123ebc9, 0xa45a982f, 0xa516deac, 0xa5e31743, 0xa5e835aa,
                0xa5e83d17, 0xa7475212, 0xa74761f6, 0xa747c0e9, 0xa747e249, 0xa747e988, 0xa7635544, 0xa7639188,
                0xa7ac7527, 0xa7ac96bd, 0xa7acd33c, 0xb23e20f5, 0xb23e5531, 0xb23e5b31, 0xb23e7872, 0xb23ecac3,
                0xb28044bd, 0xb280a40d, 0xb280df80, 0xb280e381, 0xb280ee48, 0xbca65fd6, 0xc0f1879f, 0xce5109fe,
                0xce510f5c, 0xcebd28d4, 0xcebd80b6, 0xcebd9b9e, 0xcf9ac1ce, 0xd1618217,

        };
    }
// sumcoin seeds√ ∑
    private static MainNetParams instance;
    public static synchronized MainNetParams get() {
        if (instance == null) {
            instance = new MainNetParams();
        }
        return instance;
    }

    @Override
    public String getPaymentProtocolId() {
        return PAYMENT_PROTOCOL_ID_MAINNET;
    }
}

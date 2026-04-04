# Blockchain Basics

## Definition and Nature of DApps

DApps are digital applications that run on a blockchain or peer-to-peer (P2P) network, which means they operate on a network of computers rather than a single computer.  
They are decentralized, meaning no single authority controls them.

### Comparison with Traditional Applications

Traditional web applications like Uber or Twitter run on centralized computer systems owned and operated by organizations with full control.  
In contrast, DApps run on decentralized networks such as blockchain, where control is distributed among participants.

### Examples and Context

Examples of P2P applications include BitTorrent and Popcorn Time, which operate on networks where multiple participants share content.  
In the cryptocurrency context, DApps run on public, open-source blockchain networks.

### Course Outlook

The course will further explain blockchain, decentralization, and the significance of DApps.  
It aims to equip learners with the knowledge and tools to understand and work with blockchain technology and decentralized applications.

---

## Understanding Blockchain Basics

A Blockchain is essentially an immutable database that stores transactions.  
Data on the Blockchain can only be added, not removed or altered, ensuring a secure and permanent record.

### Structure and Functionality

The Blockchain is composed of a series of blocks chained together, forming the database.  
Transactions are grouped into these blocks, which are then added sequentially.

### Practical Application and Course Context

The course will involve working with test networks and smart contracts to interact with the Blockchain.  
Concepts like migrating smart contracts and updating data will be demonstrated using tools such as the Truffle framework in later lessons.

---

## Centralized vs Decentralized Networks

### Centralized Networks

Centralized systems store and manage user data through a single private entity or authority.  
This creates a single point of failure, making the system vulnerable to data loss or manipulation if compromised.

### Decentralized Networks

Data is distributed across multiple nodes, with no central authority controlling the network.  
All nodes maintain an identical copy of the database, ensuring redundancy and resilience against failures or attacks.

### Importance for Blockchain Applications

Decentralized networks provide higher security and reliability for storing information.  
Building smart contracts and decentralized applications (DApps) on these networks leverages these benefits for more secure and trustworthy financial systems.

---

## Remix IDE Overview

The IDE displays files including built-in contracts and scripts, with Solidity files ending in ".sol" indicating smart contract code.  
The interface includes tabs for viewing code, compiling contracts, deploying and running transactions, and debugging errors.

### Compiling and Deploying Contracts

The Solidity Compiler tab is used to compile smart contracts, with errors shown in the console for debugging.  
After successful compilation, contracts can be deployed to the blockchain via the deploy and run transactions tab.

### Additional Features and Testing

Remix offers analysis tools to evaluate gas usage, security, and other contract metrics.  
Solidity unit testing is supported, which is essential for ensuring contract reliability before permanent deployment; the course will cover writing test suites in detail.

---

## Smart Contracts

### Definition and Purpose

A smart contract is an agreement between two parties where a computer program replaces the third party to enforce terms automatically.  
The code ensures that the conditions agreed upon by both parties are executed as specified without intermediaries.

### Usefulness and Applications

Smart contracts enable various systems to leverage existing blockchain networks, such as Ethereum, without building a new blockchain from scratch.  
They can be used to create custom tokens, including stablecoins like Tether, and facilitate secure transactions on the blockchain.

---

## Solidity Basics

### Setting Up Solidity Files

You create a new Solidity file by naming it with the ".sol" extension.  
This file will contain the Solidity code for your smart contract.

### Writing Comments in Solidity

Comments are written using two forward slashes (`//`) and are ignored by the compiler.  
Writing clear comments is a good practice to clarify code for yourself and others, preventing confusion and errors.

### Importance of Comments

Comments help maintain and understand code when revisiting it later.  
Developing the habit of commenting improves your skills as a software or application developer.

---

## Pragma Directive in Solidity

The pragma statement specifies the Solidity compiler version to ensure compatibility.  
Example:

pragma solidity ^0.7.0;


### Version Logic

- `^` means version 0.7.0 and above  
- Must satisfy: `X ≥ Y and X < Z`

---

## Smart Contract Structure

### Defining a Contract


contract ContractName {
}


### State Variables

Example:

uint storeData;


### Purpose

The contract is designed to receive information, store it, and return it when needed.

---

## Variables in Solidity

### Types of Variables

- Integer (`int`, `uint`)
- Boolean (`bool`)
- String (`string`)

Example:

int chocolateBar = 7;
bool chocolateTastesGood = true;
string errorMessage = "No such chocolate to be found";


### Key Points

- Static typing is required  
- Use camelCase naming  
- Statements end with `;`

---

## Functions in Solidity

### Function Syntax


function set(int x) public {
storeData = x;
}


### Get Function

Used to retrieve stored data.

### Visibility

- `public` → accessible externally  
- `private` → restricted internally  

---

## Debugging

Common errors:
- Missing semicolons  
- Syntax issues  

Fix errors using compiler messages.

---

## Deploying Smart Contracts

Steps:
1. Compile contract  
2. Go to "Deploy & Run Transactions"  
3. Use JavaScript VM  
4. Click Deploy  

### Gas Concept

- Deployment consumes gas  
- Paid using Ether  

---

## Interacting with Contracts

- Use `set` → store value  
- Use `get` → retrieve value  

Each interaction creates a transaction and consumes gas.

---

## Advanced Solidity Concepts

### Constructor

Runs once during deployment:

constructor() public payable {
owner = msg.sender;
}


### Modifiers

Example:

modifier onlyOwner {
require(msg.sender == owner);
_;
}


### Arrays


address[] wallets;


### Mappings


mapping(address => uint) balances;


---

## Example: Inheritance Smart Contract

### Key Features

- Stores family wallet addresses  
- Assigns inheritance amounts  
- Uses mapping + array  

### Payout Function

Uses loop:

for(uint i = 0; i < familyWallets.length; i++) {
familyWallets[i].transfer(Inheritance[familyWallets[i]]);
}

---

## Transactions in Blockchain

- Represent state changes  
- Are atomic (all or nothing)  
- Cryptographically signed  
- Stored in a public ledger  

---

## Coin Contract Example

### Features

- Only owner can mint coins  
- Users can send coins  

### Mint Function

function mint(address receiver, uint amount) public {
require(msg.sender == minter);
balances[receiver] += amount;
}


### Send Function

- Transfers tokens  
- Checks balance  
- Uses events  

---

## NFTs and Marketplace

### Concept

NFTs are unique digital assets stored on blockchain.

### Features

- Metadata (traits, rarity)  
- Buy/sell/trade functionality  
- Royalties for creators  

### Example Use Cases

- Digital art  
- Games  
- Collectibles  

---

## Summary

- Blockchain = immutable decentralized database  
- DApps run on decentralized networks  
- Smart contracts automate trust  
- Solidity is used to build contracts  
- Remix IDE helps develop and test  
- Core concepts: variables, functions, mappings, arrays, modifiers  
- Real-world applications include tokens, DeFi, NFTs  

--- 

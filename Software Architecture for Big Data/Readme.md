# Software Architecture for Big Data

## Evaluation Metrics for Classification

Accuracy measures the proportion of correct predictions but may not always be sufficient.
Precision quantifies the proportion of true positive predictions among all positive predictions.
Recall measures how well the model identifies all relevant positive cases.
F1 Score is the harmonic mean of precision and recall, balancing both metrics.

## Evaluation Metrics for Regression

Mean Squared Error (MSE) calculates the average squared difference between predicted and true values.
Root Mean Squared Error (RMSE) is the square root of MSE, providing error in the original units.
Mean Absolute Error (MAE) averages the absolute differences, penalizing large errors less than MSE.

## Confusion Matrix

A confusion matrix shows the performance of a classification model by displaying counts of true positives, false positives, true negatives, and false negatives for each class, helping to assess accuracy per class.

---

## Predictor Models and Interface

Predictors conform to a simple interface that takes a fixture (a game between two teams) and outputs a prediction of the outcome (home win, away win, or draw) with optional confidence.
Models range from simple ones like always predicting a home win to more complex ones like linear regression and simulators trained on historical match data.

## Training and Data Sources

Models are trained using past match results from various soccer leagues, sourced from a site called 538.
Training data includes fixtures, outcomes, and goals, which are used to build predictive models such as linear regression or points-based predictors.

## Testing and Evaluation

Automated tests check model accuracy, with baseline expectations (e.g., home predictor accuracy above 33%).
Tests help iteratively improve models by setting accuracy targets and running unit tests and longer measure tasks.
A report task evaluates models across different leagues and seasons to identify performance and potential overfitting.

## Practical Advice for Model Development

Encouragement to explore and build custom models using the provided framework and data.
Emphasis on incremental improvements in accuracy and using testing tools to guide development.
Invitation to challenge existing models and share innovative results with the course team.

---

## Model Evaluation and Bias

Models should identify patterns and generalize well to new data, which requires balanced training datasets.
Bias is the difference between the average model prediction and the true value; high bias leads to underfitting, where the model oversimplifies and ignores data details.

## Overfitting and Underfitting

Overfitting happens when a model pays too much attention to training data, failing to generalize to new data and resulting in poor predictions.
Underfitting occurs when the model is too simple to capture the underlying data patterns, often due to high bias.

## Impact of Features and Dataset Balance

An unbalanced dataset can cause bias and poor model performance.
Using too few features can cause underfitting, while too many features can cause overfitting by overwhelming the model with information.

---

## Importance of Model Evaluation

Models predict supply and demand trends, aiding business strategy formulation.
Continuous evaluation is necessary as models are refined with new data, features, or architectures.

## Automation of Model Evaluation

Frequent evaluations require automated processes similar to unit testing.
Automation frameworks help check model correctness efficiently.

## Limitations of Jupyter Notebooks in Production

Jupyter notebooks are useful for exploration and prototyping.
However, they are not ideal for production due to challenges in refining, comparing, and distributing code.

## Better Practices for Production

Creating a test harness is recommended for automating model evaluation in production environments.
This approach supports quick refinement and reliable testing of models.

---

## Characteristics of Distributed Systems

Distributed systems consist of multiple nodes that communicate and coordinate to perform tasks collectively.
They are designed to be scalable and reliable, handling increased load by distributing processes across nodes.

## Scalability and Scaling Approaches

Scalability measures how well a system manages throughput as load increases, involving computational resources like CPU and memory.
Scaling up involves enhancing a single server's hardware, while scaling out uses multiple nodes to distribute client requests, which is often more effective.

## Key Components in Distributed Architectures

**Stateless Services:** Servers do not retain session information, allowing any server to handle any request independently.
**Load Balancer:** Distributes incoming requests across multiple servers to optimize resource use and response time.
**Microservices:** Decompose applications into independent services communicating via APIs, improving modularity and maintainability.

## Cost Considerations

Transitioning to distributed architectures involves costs such as rewriting software and provisioning new hardware.

---

## Performance Metrics in Distributed Systems

Latency (response time) measures how long a request takes to be processed and returned.
Bandwidth measures the amount of data transferred per unit time in the network.

## Load Distribution and Task Assignment

Efficient distributed systems require even load distribution, but tasks may vary in processing time.
Tasks can be assigned at compile time if their size is known or dynamically at runtime if unknown.

## Concurrency and Hardware Utilization

Developers should maximize hardware use by avoiding idle processors.
Parallelism techniques like threading and multiprocessing help prevent process blocking.

## CAP Theorem and Its Impact

The CAP theorem states a distributed system can only guarantee two of three properties: Consistency, Availability, and Partition tolerance.
Network partitions are inherent in distributed systems, forcing a trade-off between consistency and availability.
Flexible handling and recovery from partitions can mitigate some CAP theorem limitations.

---

## Communication Protocols in Distributed Systems

RPCs allow execution of programs on remote machines by sending messages but may not be ideal for high throughput scenarios.
Messaging Queues provide asynchronous communication by storing messages in a buffer until the receiver processes them.

## Message-Oriented Middleware (MOM) and Message Structure

MOM encompasses mechanisms like RPCs and Messaging Queues that facilitate message-based communication.
Messages typically have a defined format with a header and body and can represent commands or events.

## Messaging Queue Models

The point-to-point model uses a FIFO queue where multiple consumers can connect, but each message is processed by only one receiver.
The publisher/subscriber model supports one-to-many or many-to-many message distribution, suitable for applications requiring multiple receivers.

---

## Messaging Queue Basics

Messages are published to an exchange, which routes them to one or more queues.
Consumers bind to queues to receive messages; messages are published to exchanges and consumed from queues.

## Direct Exchange Model

In a direct exchange, each queue binds to the exchange with a unique binding key.
Publishers send messages with a routing key that determines which queue receives the message, ensuring one-to-one message delivery.

## Advantages and Limitations

The direct exchange is simple and guarantees each message goes to exactly one queue.
However, the publisher must know all binding keys; adding new queues requires updating the publisher with new routing keys, which can be challenging under high load.

## Next Steps

Other exchange types like fan-out and topic exchanges offer different routing strategies.
The course will explore alternatives to direct exchanges for more scalable messaging solutions.

---

## Performance vs. Scalability

Scalability is the ability of a program to maintain desired response times while handling high throughput.
Performance focuses on meeting specific metrics, such as handling many requests quickly.

## Measuring Performance

Developers need to measure relevant metrics like latency and packet loss to evaluate performance.
Good instrumentation and monitoring tools like Prometheus and JMeter are essential for tracking application performance.

## Ensuring Reliability

Workload testing and simulations help emulate unusual behaviors to test system limits.
Applications should be designed to fail gracefully to recover from performance failures effectively.

---

## Key Metrics for Performance Testing

Important metrics include speed, scalability, capacity, and stability.
Capacity refers to the adequateness of the infrastructure supporting the software.

## Benchmarking Process

Benchmarking involves four phases: Planning (defining test requirements and metrics), Analysis (setting goals and resolving errors), Integration (establishing goals and stakeholder approval), and Action (developing and running tests).
Benchmarks serve as references to compare software performance.

## Load Testing Parameters

Workload intensity, which is the amount of tasks to be completed in a given time.
Workload mix, which simulates a user session to emulate real usage patterns.

---

## Identifying Issues

Performance tests help detect bottlenecks and malfunctioning components in a system.
A monitoring dashboard, such as the one described in Google's Site Reliability Engineering book, tracks key metrics called the "four golden signals": latency, traffic, errors, and saturation.

## Key Metrics for Monitoring

Latency measures the time taken to respond to requests.
Traffic indicates the demand on the system.
Errors provide insights for debugging failures.
Saturation shows the extent of resource usage.

## Resolving Issues

Once a performance problem is identified, developers can work on appropriate solutions.
Detailed and granular performance tests make it easier to pinpoint issues but require more effort to create and manage.

---

## Purpose of Custom Benchmark

Off-the-shelf tools like k6 and JMeter are great for high-traffic endpoint testing but struggle with complex flows involving multiple dependent requests.
The email verifier requires two sequential requests: registration and confirmation via a code received in an email, which standard tools cannot easily simulate.

## Benchmark Code Structure and Configuration

The benchmark is located in the applications folder and includes configurable options such as the number of workers and total registrations to test.
It acts as a fake SendGrid server to receive notification emails and process confirmation codes automatically.

## Running the Benchmark and Observing Results

Before running, the real fake SendGrid server must be stopped because the benchmark itself simulates it.
The benchmark runs multiple workers to hit endpoints, reports progress in real-time, and measures total time to complete registrations.
Example output shows processing 5,000 registrations in under two minutes, demonstrating system performance on a typical laptop.

---

## Understanding Non-Functional Requirements

Non-functional requirements specify criteria that judge the operation of a system, rather than specific behaviors or functions.
They include aspects like performance, scalability, reliability, and usability that affect the system's quality and user experience.

## Determining Non-Functional Requirements

Identifying these requirements involves analyzing system goals, stakeholder needs, and environmental constraints.
Techniques include stakeholder interviews, benchmarking, and studying similar systems to establish measurable criteria.

## Importance in System Design

Clearly defined non-functional requirements guide architecture and design decisions to meet performance and quality goals.
They help in setting realistic expectations and provide a basis for testing and validation of the system's performance.

---

## Performance Improvement Workflow

Begin by running a benchmark test to establish a baseline and observe where the system fails or underperforms.
Analyze test results carefully to understand the reasons for failure and the extent of improvement needed.

## Identifying and Diagnosing Issues

Examine logs and add detailed logging with timers in critical areas to pinpoint performance bottlenecks.
Maintain a list of identified problem areas to organize and prioritize improvements.

## Implementing and Measuring Solutions

Propose small, focused solutions for each problem area without immediately applying them.
Implement one change at a time, rerun benchmarks, and record results to isolate the impact of each modification.

## Iterate and Optimize

Compare results to select the best-performing solutions and consider combining them for further gains.
If goals are not met, repeat the process starting from deeper analysis to continue refining performance.

---

## Testing Pyramid

Emphasizes that the value of a test should outweigh its creation, execution, and maintenance costs.
Highlights that reducing test suite duration, even slightly, can save significant time overall.

## Unit Testing

Describes unit tests as tools to verify code correctness, document expected behavior, and aid application design.
Suggests further reading on unit testing to deepen understanding.

---

## Consistent Hash Exchange Basics

Messages are published to an exchange with a routing key calculated from the message, which fits into a hash space (a range of numbers).
Queues bind to the exchange with binding keys representing their share of the hash space, determining how much load they handle.

## Routing and Load Distribution

Each message's routing key places it in a specific part of the hash space, directing it to the corresponding queue.
Queues with larger binding keys get a proportionally larger share of the hash space and thus more messages.

## Dynamic Queue Addition and Scalability

Adding a new queue is straightforward: it binds to the exchange, and the hash space is reallocated among all queues.
This allows the system to handle increased load by distributing messages more evenly without the publisher needing to know about the new queues.

---

## Hashing and Its Challenges

Traditional hashing maps keys to values using a one-to-one relationship, which can be inefficient due to finite memory and fixed memory addresses.
When the number of indexed locations changes, traditional hash maps require re-indexing, which is costly.

## Consistent Hash Ring Concept

A consistent hash ring allows one location to hold multiple keys from multiple values, improving flexibility.
Locations in a consistent hash ring are assigned random numbers rather than consecutive numbering.

## How Consistent Hashing Works

Instead of modulo arithmetic, keys are mapped to the location with the smallest number greater than the key's hash.
If the key's hash is larger than all locations, it is stored at the location with the lowest number, ensuring balanced distribution without re-indexing.

---

## Load Balancing Algorithms

Load balancers can use algorithms like round robin or consistent hash exchange.
Session identifiers such as cookies can map requests to specific servers.

## Consistent Hash Exchange Mechanism

The algorithm distributes routing keys among message queues, not the message content.
Messages with the same routing key go to the same queue, and each message is dispatched to only one queue.

## Routing Process in Consistent Hash Exchange

A hash is calculated from the routing key, which is usually in the message header.
Queues are bound to exchange routes based on binding weight, which defines the range of locations a queue handles.
The computed hash selects the corresponding queue, and the message is dispatched accordingly.

## Additional Note

RabbitMQ includes consistent hash exchange as a built-in feature, and further documentation is recommended for detailed understanding.

---

## Message Queues and Asynchronous Processing

Message queues act as buffers between producers (senders) and consumers (receivers), allowing processes to operate independently.
They enable asynchronous handling of tasks, preventing slowdowns in user experience caused by synchronous database operations.

## Example System Architecture

A UserActionHandler generates database operations based on user actions and pushes them onto the message queue.
A DatabaseWorker consumes operations from the queue and executes them on the database asynchronously.

## Benefits and Enhancements

This approach allows quick handling of user actions without waiting for database completion and helps manage peak loads by buffering operations.
Further improvements include parallel processing with multiple workers, priority queues for urgent tasks, and error handling with retries or dead-letter queues.

---

## CAP Theorem Basics

Consistency means every server returns the correct response to a request.
Availability means every request eventually receives a response.
Partition tolerance means the system can handle communication failures between servers.

## Applying the CAP Theorem

It is impossible to have all three properties simultaneously in a distributed system.
Partition tolerance is essential in modern cloud-based applications due to network unreliability.
The real trade-off is between consistency and availability.

## Balancing Consistency and Availability

Systems can favor consistency (e.g., using Postgres) or availability (e.g., using Cassandra).
Hybrid approaches exist, such as using message queues to improve availability at some cost to consistency.
The choice depends on the problem domain, e.g., emergency services require strong consistency, while recommendation systems prioritize availability.

---

## CAP Theorem Overview

The CAP theorem states that a distributed system can only guarantee two out of three properties: Consistency, Availability, and Partition tolerance.
In the event of a network partition, systems must choose between being consistent (CP) or available (AP), as both cannot be guaranteed simultaneously.

## Revisiting CAP and Network Partitions

Guy Brewer revisited the CAP theorem in 2012, noting that the "two out of three" idea can be misleading because network partitions are rare.
Systems typically sacrifice either consistency or availability when partitions occur, but new technologies help recover from partitions more effectively.

## Database Transaction Properties: ACID and BASE

ACID properties focus on consistency in traditional databases: Atomicity, Consistency, Isolation, and Durability.
BASE (Basically Available) emphasizes always providing a response in distributed systems, even if it indicates failure, prioritizing availability over strict consistency.

---

## CAP Theorem Overview

The CAP theorem addresses trade-offs between Consistency, Availability, and Partition Tolerance in distributed systems.
It is essential for understanding how distributed systems behave under network partitions and failures.

## Relevance to DevOps and Configuration Management

The reading explores how the CAP theorem impacts current deployment and operational practices in DevOps.
It highlights the trade-offs that must be managed when designing and operating distributed systems in production environments.

## Additional Resources

The reading includes a recommended CAP Theorem reading list for deeper exploration.
These materials help learners grasp the practical implications of CAP in real-world systems.

---

## Partition Tolerance in Distributed Systems

Partition tolerance means the system continues to operate despite network partitions or communication breakdowns between nodes.
It is a fundamental requirement that cannot be sacrificed when designing distributed systems.

## CAP Theorem Trade-offs

The CAP theorem states that a distributed system can only guarantee two out of three properties: Consistency, Availability, and Partition tolerance.
Since partition tolerance is essential, systems must balance trade-offs between consistency and availability.

## Amazon's Approach

Amazon's highly available key-value store provides a practical example of how to handle CAP theorem trade-offs.
Their system prioritizes availability and partition tolerance, accepting eventual consistency to maintain performance and reliability.

---

## Perspectives on the CAP Theorem

It provides a classic interpretation of the implications of the CAP theorem.
Helps understand the trade-offs between Consistency, Availability, and Partition Tolerance in distributed systems.

## Lessons from Giant-Scale Services

Offers practical approaches for designing systems that maintain high availability.
Shares insights from large-scale service architectures to handle availability challenges.

## Brewer's Harvest, Yield, and Scalable Tolerant Systems

Presents strategies to achieve high availability in distributed systems.
Discusses methods to balance system yield and scalability while tolerating faults.

---

## Key Findings on Dispatching Policies

With limited memory and a modest messaging budget, all dispatching policies result in queueing delays that do not vanish.
Increasing memory or messaging slightly allows certain symmetric pull-based dispatching policies to achieve vanishing queueing delay.

## Variants of Pull-Based Dispatching Policies

Two variants of a simple symmetric pull-based policy can eliminate queueing delay with a small increase in resources.
A third variant, using a minimal message rate proportional to arrival rate, achieves finite and uniformly bounded queueing delay even under heavy traffic, improving over traditional M/M/1 queue delays.

## Future Research Directions

Investigate if results hold without the symmetry assumption.
Explore relaxing assumptions on server homogeneity.
Extend analysis to general job size distributions and other service disciplines like processor sharing or LIFO.

---

## High Availability Setup

Typically involves a Master and Replica database instances where data is synchronized through replication.
For example, MySQL uses binary log replication where the Master records changes and the Replica applies these changes to stay in sync.

## Replication Process

The Master maintains a binary log of all data changes.
The Replica fetches these changes and applies them to its own data to maintain an exact copy.

## Failover Mechanism

If the Master fails, an automatic failover promotes the Replica to become the new Master.
The failover process includes checking Master availability, selecting a new Master, and promoting it.

## Considerations and Complexity

The network and storage must handle the replication traffic without performance loss.
More complex architectures may include multiple replicas, load balancers, or sharding to distribute load and improve availability further.

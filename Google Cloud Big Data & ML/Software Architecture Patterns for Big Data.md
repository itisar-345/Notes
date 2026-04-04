# Software Architecture for Big Data

## Evaluation Metrics for Classification

- Accuracy measures the proportion of correct predictions but may not always be sufficient.  
- Precision quantifies the proportion of true positive predictions among all positive predictions.  
- Recall measures how well the model identifies all relevant positive cases.  
- F1 Score is the harmonic mean of precision and recall, balancing both metrics.  

## Evaluation Metrics for Regression

- Mean Squared Error (MSE) calculates the average squared difference between predicted and true values.  
- Root Mean Squared Error (RMSE) is the square root of MSE, providing error in the original units.  
- Mean Absolute Error (MAE) averages the absolute differences, penalizing large errors less than MSE.  

## Confusion Matrix

A confusion matrix shows the performance of a classification model by displaying counts of true positives, false positives, true negatives, and false negatives for each class, helping to assess accuracy per class.

---

## Predictor Models and Interface

- Predictors conform to a simple interface that takes a fixture (a game between two teams) and outputs a prediction of the outcome (home win, away win, or draw) with optional confidence.  
- Models range from simple ones like always predicting a home win to more complex ones like linear regression and simulators trained on historical match data.  

## Training and Data Sources

- Models are trained using past match results from various soccer leagues, sourced from a site called 538.  
- Training data includes fixtures, outcomes, and goals, which are used to build predictive models such as linear regression or points-based predictors.  

## Testing and Evaluation

- Automated tests check model accuracy, with baseline expectations (e.g., home predictor accuracy above 33%).  
- Tests help iteratively improve models by setting accuracy targets and running unit tests and longer measure tasks.  
- A report task evaluates models across different leagues and seasons to identify performance and potential overfitting.  

## Practical Advice for Model Development

- Encouragement to explore and build custom models using the provided framework and data.  
- Emphasis on incremental improvements in accuracy and using testing tools to guide development.  
- Invitation to challenge existing models and share innovative results with the course team.  

---

## Model Evaluation and Bias

- Models should identify patterns and generalize well to new data, which requires balanced training datasets.  
- Bias is the difference between the average model prediction and the true value; high bias leads to underfitting, where the model oversimplifies and ignores data details.  

## Overfitting and Underfitting

- Overfitting happens when a model pays too much attention to training data, failing to generalize to new data and resulting in poor predictions.  
- Underfitting occurs when the model is too simple to capture the underlying data patterns, often due to high bias.  

## Impact of Features and Dataset Balance

- An unbalanced dataset can cause bias and poor model performance.  
- Using too few features can cause underfitting, while too many features can cause overfitting by overwhelming the model with information.  

---

## Importance of Model Evaluation

- Models predict supply and demand trends, aiding business strategy formulation.  
- Continuous evaluation is necessary as models are refined with new data, features, or architectures.  

## Automation of Model Evaluation

- Frequent evaluations require automated processes similar to unit testing.  
- Automation frameworks help check model correctness efficiently.  

## Limitations of Jupyter Notebooks in Production

- Jupyter notebooks are useful for exploration and prototyping.  
- However, they are not ideal for production due to challenges in refining, comparing, and distributing code.  

## Better Practices for Production

- Creating a test harness is recommended for automating model evaluation in production environments.  
- This approach supports quick refinement and reliable testing of models.  

---

## Characteristics of Distributed Systems

- Distributed systems consist of multiple nodes that communicate and coordinate to perform tasks collectively.  
- They are designed to be scalable and reliable, handling increased load by distributing processes across nodes.  

## Scalability and Scaling Approaches

- Scalability measures how well a system manages throughput as load increases, involving computational resources like CPU and memory.  
- Scaling up involves enhancing a single server's hardware, while scaling out uses multiple nodes to distribute client requests, which is often more effective.  

## Key Components in Distributed Architectures

- **Stateless Services:** Servers do not retain session information, allowing any server to handle any request independently.  
- **Load Balancer:** Distributes incoming requests across multiple servers to optimize resource use and response time.  
- **Microservices:** Decompose applications into independent services communicating via APIs, improving modularity and maintainability.  

## Cost Considerations

- Transitioning to distributed architectures involves costs such as rewriting software and provisioning new hardware.  

---

## Performance Metrics in Distributed Systems

- Latency (response time) measures how long a request takes to be processed and returned.  
- Bandwidth measures the amount of data transferred per unit time in the network.  

## Load Distribution and Task Assignment

- Efficient distributed systems require even load distribution, but tasks may vary in processing time.  
- Tasks can be assigned at compile time if their size is known or dynamically at runtime if unknown.  

## Concurrency and Hardware Utilization

- Developers should maximize hardware use by avoiding idle processors.  
- Parallelism techniques like threading and multiprocessing help prevent process blocking.  

## CAP Theorem and Its Impact

- The CAP theorem states a distributed system can only guarantee two of three properties: Consistency, Availability, and Partition tolerance.  
- Network partitions are inherent in distributed systems, forcing a trade-off between consistency and availability.  
- Flexible handling and recovery from partitions can mitigate some CAP theorem limitations.  

---

## Communication Protocols in Distributed Systems

- RPCs allow execution of programs on remote machines by sending messages but may not be ideal for high throughput scenarios.  
- Messaging Queues provide asynchronous communication by storing messages in a buffer until the receiver processes them.  

## Message-Oriented Middleware (MOM) and Message Structure

- MOM encompasses mechanisms like RPCs and Messaging Queues that facilitate message-based communication.  
- Messages typically have a defined format with a header and body and can represent commands or events.  

## Messaging Queue Models

- The point-to-point model uses a FIFO queue where multiple consumers can connect, but each message is processed by only one receiver.  
- The publisher/subscriber model supports one-to-many or many-to-many message distribution, suitable for applications requiring multiple receivers.  

---

## Messaging Queue Basics

- Messages are published to an exchange, which routes them to one or more queues.  
- Consumers bind to queues to receive messages; messages are published to exchanges and consumed from queues.  

## Direct Exchange Model

- In a direct exchange, each queue binds to the exchange with a unique binding key.  
- Publishers send messages with a routing key that determines which queue receives the message, ensuring one-to-one message delivery.  

## Advantages and Limitations

- The direct exchange is simple and guarantees each message goes to exactly one queue.  
- However, the publisher must know all binding keys; adding new queues requires updating the publisher with new routing keys, which can be challenging under high load.  

## Next Steps

- Other exchange types like fan-out and topic exchanges offer different routing strategies.  
- The course will explore alternatives to direct exchanges for more scalable messaging solutions.  

---

## Performance vs. Scalability

- Scalability is the ability of a program to maintain desired response times while handling high throughput.  
- Performance focuses on meeting specific metrics, such as handling many requests quickly.  

## Measuring Performance

- Developers need to measure relevant metrics like latency and packet loss to evaluate performance.  
- Good instrumentation and monitoring tools like Prometheus and JMeter are essential for tracking application performance.  

## Ensuring Reliability

- Workload testing and simulations help emulate unusual behaviors to test system limits.  
- Applications should be designed to fail gracefully to recover from performance failures effectively.  

---

## Key Metrics for Performance Testing

- Important metrics include speed, scalability, capacity, and stability.  
- Capacity refers to the adequateness of the infrastructure supporting the software.  

## Benchmarking Process

- Benchmarking involves four phases:  
  - Planning (defining test requirements and metrics)  
  - Analysis (setting goals and resolving errors)  
  - Integration (establishing goals and stakeholder approval)  
  - Action (developing and running tests)  
- Benchmarks serve as references to compare software performance.  

## Load Testing Parameters

- Workload intensity, which is the amount of tasks to be completed in a given time.  
- Workload mix, which simulates a user session to emulate real usage patterns.  

---

## Identifying Issues

- Performance tests help detect bottlenecks and malfunctioning components in a system.  
- A monitoring dashboard tracks key metrics called the "four golden signals": latency, traffic, errors, and saturation.  

## Key Metrics for Monitoring

- Latency measures the time taken to respond to requests.  
- Traffic indicates the demand on the system.  
- Errors provide insights for debugging failures.  
- Saturation shows the extent of resource usage.  

## Resolving Issues

- Once a performance problem is identified, developers can work on appropriate solutions.  
- Detailed and granular performance tests make it easier to pinpoint issues but require more effort to create and manage.  

---

## Purpose of Custom Benchmark

- Off-the-shelf tools like k6 and JMeter are great for high-traffic endpoint testing but struggle with complex flows involving multiple dependent requests.  
- The email verifier requires two sequential requests: registration and confirmation via a code received in an email.  

## Benchmark Code Structure and Configuration

- The benchmark includes configurable options such as the number of workers and total registrations.  
- It acts as a fake SendGrid server to receive notification emails and process confirmation codes automatically.  

## Running the Benchmark and Observing Results

- The benchmark runs multiple workers, reports progress in real-time, and measures total execution time.  
- Example output shows processing 5,000 registrations in under two minutes.  

---

## Understanding Non-Functional Requirements

- Non-functional requirements specify criteria that judge system operation rather than specific behaviors.  
- They include performance, scalability, reliability, and usability.  

## Determining Non-Functional Requirements

- Identifying these requirements involves analyzing system goals, stakeholder needs, and constraints.  
- Techniques include stakeholder interviews and benchmarking.  

## Importance in System Design

- Clearly defined non-functional requirements guide architecture decisions.  
- They help set expectations and validate system performance.  

---

## Performance Improvement Workflow

- Begin with a benchmark test to establish a baseline.  
- Analyze results to identify failures and bottlenecks.  

## Identifying and Diagnosing Issues

- Examine logs and add detailed logging with timers.  
- Maintain a list of problem areas.  

## Implementing and Measuring Solutions

- Propose small, focused solutions.  
- Implement one change at a time and rerun benchmarks.  

## Iterate and Optimize

- Compare results and combine improvements.  
- Repeat the process if goals are not met.  

---

## Testing Pyramid

- Emphasizes that test value should outweigh its cost.  
- Reducing test duration saves significant time.  

## Unit Testing

- Verifies code correctness and documents behavior.  

---

## Consistent Hash Exchange Basics

- Messages are routed using a hash space based on routing keys.  
- Queues bind with keys defining their share of load.  

## Routing and Load Distribution

- Messages are directed to queues based on hash values.  
- Larger bindings receive more messages.  

## Dynamic Queue Addition and Scalability

- New queues can be added easily with automatic load redistribution.  

---

## Hashing and Its Challenges

- Traditional hashing can be inefficient due to fixed memory.  
- Re-indexing is costly when locations change.  

## Consistent Hash Ring Concept

- Allows flexible mapping with improved distribution.  

## How Consistent Hashing Works

- Keys map to the nearest location in the hash ring.  

---

## Load Balancing Algorithms

- Algorithms include round robin and consistent hashing.  

## Consistent Hash Exchange Mechanism

- Messages with the same routing key go to the same queue.  

## Routing Process

- Hash determines queue selection based on binding weight.  

---

## Message Queues and Asynchronous Processing

- Message queues buffer communication between producers and consumers.  

## Example System Architecture

- User actions are pushed to a queue and processed asynchronously.  

## Benefits and Enhancements

- Improves performance and handles peak loads.  

---

## CAP Theorem Basics

- Consistency: Correct response  
- Availability: Response received  
- Partition tolerance: Handles failures  

## Applying the CAP Theorem

- Only two properties can be guaranteed simultaneously.  

## Balancing Trade-offs

- Systems may favor consistency or availability.  

---

## CAP Theorem Overview

- Trade-offs are essential in distributed system design.  

## ACID vs BASE

- ACID ensures consistency.  
- BASE prioritizes availability.  

---

## Partition Tolerance in Distributed Systems

- Essential for handling network failures.  

## Amazon's Approach

- Prioritizes availability with eventual consistency.  

---

## High Availability Setup

- Uses Master and Replica databases.  

## Replication Process

- Changes are logged and replicated.  

## Failover Mechanism

- Replica becomes Master if failure occurs.  

## Considerations and Complexity

- Requires handling network and storage efficiency.  

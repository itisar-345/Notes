 # Social Media Platform Module
 
 This module implements a comprehensive social media platform demonstrating
 core Object-Oriented Programming (OOP) concepts.
 
 OOP Concepts Covered:
 
 1. **Encapsulation**
    - Private and public data members to protect internal state
    - Getter and setter methods for controlled access to object properties
    - Information hiding to maintain data integrity
    - Keywords: `private`, `public`, `protected`
    - **Experiments**:
      - Change `private` members to `public` in User class and observe direct access
      - Remove getter/setter methods and see compilation errors
      - Add validation in setters to prevent invalid data
 
 2. **Abstraction**
    - Abstract classes defining contracts for platform entities
    - Interface-based design for loosely coupled components
    - Hiding complex implementation details from users
    - Keywords: `abstract`, `interface`
    - **Experiments**:
      - Try instantiating an abstract class directly
      - Implement multiple interfaces on a single class
      - Create different implementations of the same interface
 
 3. **Inheritance**
    - User, Post, and Comment hierarchies sharing common functionality
    - Base classes providing reusable properties and methods
    - IS-A relationships between platform entities
    - Keywords: `extends`, `super`, `protected`
    - **Experiments**:
      - Change `protected` members to `private` and trace inheritance access issues
      - Override parent methods in child classes and call `super()`
      - Create multi-level inheritance (grandparent → parent → child)
 
 4. **Polymorphism**
    - Method overriding for different user types (Admin, Regular User, etc.)
    - Runtime binding for flexible behavior across object types
    - Method overloading for varied parameter handling
    - Keywords: `override`, `virtual`
    - **Experiments**:
      - Create Admin and RegularUser classes extending User
      - Override deletePost() differently for each type
      - Use polymorphic references to call appropriate methods at runtime
 
 5. **Association & Aggregation**
    - Users creating and managing posts and comments
    - One-to-many relationships between entities
    - Composite object structures
    - **Experiments**:
      - Store Post objects in a User's List/Array
      - Remove a user and observe post references
 
 6. **Composition**
    - Complex objects built from simpler components
    - Strong ownership relationships between objects
    - **Experiments**:
      - Add Address class as a component of User
      - Ensure child objects are created/destroyed with parent
 
 7. **Static Members**
    - Class-level variables for shared platform data
    - Static methods for utility operations
    - Keywords: `static`
    - **Experiments**:
      - Track total user count with a static variable
      - Create static utility methods for date formatting
      - Modify static members and observe changes across all instances
 
 8. **Constructors & Destructors**
    - Object initialization with various constructor patterns
    - Resource cleanup and state management
    - Keywords: Constructor names matching class names, `~ClassName()` for destructors
    - **Experiments**:
      - Create overloaded constructors with different parameters
      - Use constructor chaining with `this()` or `super()`
      - Log constructor/destructor calls to track object lifecycle
 
 9. **Access Modifiers**
    - `public`: Methods and properties accessible from anywhere
    - `private`: Restricted access within the class only
    - `protected`: Accessible within the class and derived classes
    - **Experiments**:
      - Systematically change access modifiers and note compilation errors
      - Test access from main method, same package, different packages
 
 10. **Exception Handling**
     - Try-catch blocks for error management
     - Custom exceptions for platform-specific errors
     - Graceful error recovery and validation
     - Keywords: `try`, `catch`, `throw`, `finally`
     - **Experiments**:
      - Throw custom InvalidUserException when validating inputs
      - Catch multiple exceptions with different handling logic
      - Use finally block to log operations
 

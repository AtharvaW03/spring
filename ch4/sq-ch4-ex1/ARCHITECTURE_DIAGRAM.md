# Project Architecture Diagram

## Class Diagram with Interfaces and Relationships

```
┌─────────────────────────────────────────────────────────────────┐
│                          MAIN                                    │
│                     (Main.java)                                  │
│─────────────────────────────────────────────────────────────────│
│  Creates:                                                         │
│  1. DBCommentRepository                                          │
│  2. EmailCommentNotificationProxy                                │
│  3. CommentService                                               │
│  4. Comment object                                               │
│                                                                   │
│  Operations:                                                      │
│  - Set comment.author = "Atharva"                                │
│  - Set comment.text = "Demo comment"                             │
│  - Call commentService.publishComment(comment)                   │
└─────────────────────────────────────────────────────────────────┘
                              │
                              │ instantiates
                              ├─────────────────────────┬──────────────────────┐
                              ↓                         ↓                      ↓
                   ┌──────────────────────┐  ┌─────────────────────┐  ┌──────────────┐
                   │ CommentService       │  │ DBCommentRepository │  │ EmailComment │
                   │ (Service Layer)      │  │ (Repository Impl)   │  │ Notification │
                   ├──────────────────────┤  ├─────────────────────┤  │ Proxy        │
                   │ - commentRepository  │  │ Implements:         │  │ (Proxy Impl) │
                   │   (CommentRepository)│  │  CommentRepository  │  ├──────────────┤
                   │ - commentNotif...    │  │                     │  │ Implements:  │
                   │   (CommentNotif...   │  │ Methods:            │  │  CommentNot..│
                   │    Proxy)            │  │ + storeComment()    │  │              │
                   ├──────────────────────┤  │   └─ Prints to      │  │ Methods:     │
                   │ Methods:             │  │      System.out     │  │ + sendComm..()│
                   │ + publishComment()   │  └─────────────────────┘  │   └─ Prints  │
                   │   ├─ Calls:          │                           │      to      │
                   │   │  repository      │      ▲                    │      System. │
                   │   │  .storeComment() │      │                    │      out     │
                   │   │  .sendComment()  │      │ implements          │              │
                   │   │                  │      │                    └──────────────┘
                   └──────────────────────┘      │                           ▲
                              │                  │                           │
                              │                  │                           │ implements
                        depends on           implements                      │
                              │                  │                           │
                              ├──────────────────┴───────────────────────────┤
                              │
                   ┌──────────────────────┐    ┌─────────────────────┐
                   │ CommentRepository    │    │ CommentNotification │
                   │ (Interface)          │    │ Proxy (Interface)   │
                   ├──────────────────────┤    ├─────────────────────┤
                   │ + storeComment()     │    │ + sendComment()     │
                   │   (abstract)         │    │   (abstract)        │
                   └──────────────────────┘    └─────────────────────┘
                              ▲                           ▲
                              │                           │
                              │                           │
                   ┌──────────────────────┐    ┌─────────────────────┐
                   │ DBCommentRepository  │    │ EmailCommentNotif.. │
                   │ implements           │    │ Proxy               │
                   │ CommentRepository    │    │ implements          │
                   └──────────────────────┘    │ CommentNotif...Proxy│
                                               └─────────────────────┘
                                               
                   ┌──────────────────────┐
                   │ Comment              │
                   │ (Model/Entity)       │
                   ├──────────────────────┤
                   │ - author: String     │
                   │ - text: String       │
                   ├──────────────────────┤
                   │ + getAuthor()        │
                   │ + setAuthor()        │
                   │ + getText()          │
                   │ + setText()          │
                   └──────────────────────┘
                              ▲
                              │ passed to
                              │
                  ┌───────────┴─────────────┐
                  │                         │
         - storeComment(Comment)    - sendComment(Comment)
         - publishComment(Comment)
```

## Method Flow Diagram

```
Main.main()
  │
  ├─ commentRepository = new DBCommentRepository()
  ├─ commentNotificationProxy = new EmailCommentNotificationProxy()
  ├─ commentService = new CommentService(repository, proxy)
  │
  ├─ comment = new Comment()
  ├─ comment.setAuthor("Atharva")
  ├─ comment.setText("Demo comment")
  │
  └─ commentService.publishComment(comment)
       │
       ├─ commentRepository.storeComment(comment)
       │   └─ DBCommentRepository.storeComment()
       │       └─ System.out.println("Storing comment: Demo comment")
       │
       └─ commentNotificationProxy.sendComment(comment)
           └─ EmailCommentNotificationProxy.sendComment()
               └─ System.out.println("Sending notification for comment: Demo comment")
```

## Interface Implementation Summary

### CommentRepository Interface
- **Location**: `com.sprint.repositories`
- **Methods**: 
  - `void storeComment(Comment comment)`
- **Implementations**:
  - `DBCommentRepository` - stores comment to database (prints to System.out)

### CommentNotificationProxy Interface
- **Location**: `com.sprint.proxies`
- **Methods**:
  - `void sendComment(Comment comment)`
- **Implementations**:
  - `EmailCommentNotificationProxy` - sends email notification (prints to System.out)

## Dependency Injection Pattern

The project uses **Constructor-based Dependency Injection**:

```
CommentService constructor:
  └─ Accepts: CommentRepository, CommentNotificationProxy
  └─ Stores as instance variables
  └─ Uses them in publishComment() method

Main creates concrete implementations:
  └─ DBCommentRepository (implements CommentRepository)
  └─ EmailCommentNotificationProxy (implements CommentNotificationProxy)
  └─ Injects into CommentService via constructor
```

## Package Structure

```
com.sprint
├── main/
│   └── Main.java (Entry point)
├── model/
│   └── Comment.java (Entity/POJO)
├── proxies/
│   ├── CommentNotificationProxy.java (Interface)
│   └── EmailCommentNotificationProxy.java (Implementation)
├── repositories/
│   ├── CommentRepository.java (Interface)
│   └── DBCommentRepository.java (Implementation)
└── services/
    └── CommentService.java (Service layer)
```

## Design Patterns Used

1. **Repository Pattern**: Abstracts data persistence layer
2. **Proxy Pattern**: Proxies external notification service
3. **Dependency Injection**: Constructor injection of dependencies
4. **Service Layer**: Business logic separation in CommentService

## Data Flow

```
Input: Comment object (author, text)
         │
         ├─ CommentService.publishComment()
         │   ├─ Stores in repository
         │   │   └─ DBCommentRepository
         │   │       └─ Prints: "Storing comment: [text]"
         │   │
         │   └─ Sends notification via proxy
         │       └─ EmailCommentNotificationProxy
         │           └─ Prints: "Sending notification for comment: [text]"
         │
Output: Console output from both repository and proxy
```


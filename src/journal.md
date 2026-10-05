Phase 1
The Adapter pattern lets the program work with an older firewall without changing its original methods. I created the SecurityLog interface and used FirewallAdapter to connect it to LegacyFirewall. The adapter translates the modern method calls into the older method names.
This follows the Principle of Least Knowledge because the main program only needs to know about SecurityLog. It does not need to know how the legacy firewall works internally. This makes the code easier to maintain if we add other types of security devices later.

Phase 2
In Phase 2, I created separate classes for network traffic, user access, and encryption. During the emergency, I kept track of the ports, usernames, and database name so I could reverse the actions during the all-clear sequence.  Doing everything manually could become difficult and lead to mistakes if the system handled thousands of ports and users. It would be easy to forget an action or restore the wrong account. A simpler system that handles these operations automatically would make the code easier to manage.

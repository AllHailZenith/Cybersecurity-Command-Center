Phase 1
The Adapter pattern lets the program work with an older firewall without changing its original methods. I created the SecurityLog interface and used FirewallAdapter to connect it to LegacyFirewall. The adapter translates the modern method calls into the older method names.
This follows the Principle of Least Knowledge because the main program only needs to know about SecurityLog. It does not need to know how the legacy firewall works internally. This makes the code easier to maintain if we add other types of security devices later.

Phase 2
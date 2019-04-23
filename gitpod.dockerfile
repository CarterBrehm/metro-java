FROM gitpod/workspace-full

USER root

# install via Ubuntu's APT:
# * Apache - the web server
# * Multitail - see logs live in the terminal
RUN apt-get update \
 && apt-get -y install ant \
 && apt-get clean && rm -rf /var/lib/apt/lists/* /tmp/*
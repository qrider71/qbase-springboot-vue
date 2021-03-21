FROM gitpod/workspace-full

# Install custom tools, runtimes, etc.
# For example "bastet", a command-line tetris clone:
# RUN brew install bastet
#
# More information: https://www.gitpod.io/docs/config-docker/

USER gitpod

# Install OpenShift client tools
RUN mkdir -p /home/gitpod/.oc && \
    cd /home/gitpod/.oc && \
    echo "installing OpenShift client tools" && \
    curl -skfL -o openshift-client-linux.tar.gz https://github.com/openshift/okd/releases/download/4.5.0-0.okd-2020-07-29-070316/openshift-client-linux-4.5.0-0.okd-2020-07-29-070316.tar.gz && \
    gzip -d openshift-client-linux.tar.gz && \
    tar -xvf openshift-client-linux.tar && \
    rm -rf *.tar

ENV PATH="$PATH:/home/gitpod/.oc"

USER root

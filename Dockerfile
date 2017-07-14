FROM hseeberger/scala-sbt:scala-2.12.2-sbt-0.13.15

# cache depencies
COPY ./bowling-project/project /home/app/bowling-project/project
COPY ./bowling-project/build.sbt /home/app/bowling-project/build.sbt
WORKDIR /home/app/bowling-project
RUN sbt reload
RUN sbt update

# cache files
COPY ./bowling-project/src /home/app/bowling-project/src
CMD sbt test

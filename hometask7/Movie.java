package com.htp.hometask7;

public class Movie {

    public Movie() {
    }

    @Override
    public String toString() {
        return "Movie{}";
    }

    public void firtsMethod() {
        System.out.println(" Movie collection:");
    }

    class MovieCollection {
        private String originalName;
        private String producer;
        private String genre;
        private String movieDuration;

        public MovieCollection() {
        }

        public MovieCollection(String originalName, String producer, String genre, String movieDuration) {
            this.originalName = originalName;
            this.producer = producer;
            this.genre = genre;
            this.movieDuration = movieDuration;
        }

        public String getOriginalName() {
            return originalName;
        }

        public void setOriginalName(String originalName) {
            this.originalName = originalName;
        }

        public String getProducer() {
            return producer;
        }

        public void setProducer(String producer) {
            this.producer = producer;
        }

        public String getGenre() {
            return genre;
        }

        public void setGenre(String genre) {
            this.genre = genre;
        }

        public String getMovieDuration() {
            return movieDuration;
        }

        public void setMovieDuration(String movieDuration) {
            this.movieDuration = movieDuration;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            MovieCollection that = (MovieCollection) o;

            if (originalName != null ? !originalName.equals(that.originalName) : that.originalName != null)
                return false;
            if (producer != null ? !producer.equals(that.producer) : that.producer != null) return false;
            if (genre != null ? !genre.equals(that.genre) : that.genre != null) return false;
            return movieDuration != null ? movieDuration.equals(that.movieDuration) : that.movieDuration == null;
        }

        @Override
        public int hashCode() {
            int result = originalName != null ? originalName.hashCode() : 0;
            result = 31 * result + (producer != null ? producer.hashCode() : 0);
            result = 31 * result + (genre != null ? genre.hashCode() : 0);
            result = 31 * result + (movieDuration != null ? movieDuration.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "MovieCollection{" +
                    "originalName='" + originalName + '\'' +
                    ", producer='" + producer + '\'' +
                    ", genre='" + genre + '\'' +
                    ", movieDuration='" + movieDuration + '\'' +
                    '}';
        }

        public void monvieMethod(String originalName, String producer, String genre, String movieDuration) {
            System.out.println(" \"" + originalName + "\": producer - " +
                    producer + ",  genre - " + genre + ",  duration - " +
                    movieDuration);
        }
    }


}

package Collections;

import java.util.*;

public class VotingSystem {
    Map<String, Integer> voteCount = new HashMap<>();
    Map<String, Integer> orderedVotes = new LinkedHashMap<>();
    TreeMap<String, Integer> sortedVotes = new TreeMap<>();

    void castVote(String candidate) {
        voteCount.put(candidate, voteCount.getOrDefault(candidate, 0) + 1);
        orderedVotes.put(candidate, voteCount.get(candidate));
        sortedVotes.put(candidate, voteCount.get(candidate));
    }

    void displayResults() {
        System.out.println("Vote Counts (unordered): " + voteCount);
        System.out.println("Vote Counts (ordered): " + orderedVotes);
        System.out.println("Vote Counts (sorted): " + sortedVotes);
    }

    public static void main(String[] args) {
        VotingSystem system = new VotingSystem();
        system.castVote("Alice");
        system.castVote("Bob");
        system.castVote("Alice");
        system.castVote("Charlie");
        system.castVote("Bob");
        system.castVote("Alice");

        system.displayResults();
    }
}


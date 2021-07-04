package ahmetcetinkaya.HRMSProjectBackend.core.business.constants;

public class Messages {
	public static String passwordsNotMatch = "Passwords are not match.";

	public static String added(final String name) {
		return name + " has added.";
	}

	public static String updated(final String name) {
		return name + " has updated.";
	}

	public static String deleted(final String name) {
		return name + " has deleted.";
	}

	public static String notFound(final String name) {
		return name + " not found.";
	}

	public static String awaitingApproval(final String name) {
		return name + " is awaiting approval.";
	}

	public static String alreadyExists(final String name) {
		return name + " already exists.";
	}

	public static String verified(final String name) {
		return name + " has been verified.";
	}

	public static String notVerified(final String name) {
		return name + " could not be verified.";
	}

	public static String complete(final String name) {
		return name + " is complete.";
	}
}

package au.org.consumerdatastandards.support;

import au.org.consumerdatastandards.support.data.IntegerRange;

import java.util.Objects;

/**
 * Semantic Versioning
 */
public class SemVer implements Comparable<SemVer> {

    @IntegerRange(min = 0)
    private final int major;

    @IntegerRange(min = 0)
    private final int minor;

    @IntegerRange(min = 0)
    private final int patch;

    public SemVer(int major, int minor, int patch) {
        this.major = major;
        this.minor = minor;
        this.patch = patch;
    }

    @Override
    public String toString() {
        return String.format("%d.%d.%d", major, minor, patch);
    }

    @Override
    public int compareTo(SemVer o) {
        if (major != o.major) {
            return major - o.major;
        }
        if (minor != o.minor) {
            return minor - o.minor;
        }
        return patch - o.patch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SemVer semVer = (SemVer) o;
        return major == semVer.major &&
            minor == semVer.minor &&
            patch == semVer.patch;
    }

    @Override
    public int hashCode() {
        return Objects.hash(major, minor, patch);
    }
}
